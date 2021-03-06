/************************************************************************************
*
*   This file is part of triki
*
*   Written by Donald McIntosh (dbm@opentechnology.net) 
*
*   triki is free software: you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*   the Free Software Foundation, either version 3 of the License, or
*   (at your option) any later version.
*
*   triki is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU General Public License for more details.
*
*   You should have received a copy of the GNU General Public License
*   along with triki.  If not, see <http://www.gnu.org/licenses/>.
*
************************************************************************************/

package net.opentechnology.triki.core.resources


import javax.inject.Inject
import javax.servlet.annotation.MultipartConfig
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces
import javax.ws.rs.core.CacheControl
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response
import javax.ws.rs.core.Response.ResponseBuilder
import javax.ws.rs.QueryParam

import org.apache.commons.io.IOUtils
import org.apache.cxf.jaxrs.ext.multipart.MultipartBody
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.ApplicationContext
import org.stringtemplate.v4.ST
import net.opentechnology.triki.auth.AuthorisationManager
import net.opentechnology.triki.core.boot.CachedPropertyStore;
import net.opentechnology.triki.core.boot.CoreModule
import net.opentechnology.triki.core.dto.ContentDto
import net.opentechnology.triki.core.dto.GroupDto
import net.opentechnology.triki.core.dto.MediaTypeDto
import net.opentechnology.triki.core.expander.ExpanderException;
import net.opentechnology.triki.core.template.TemplateException;;
import net.opentechnology.triki.core.template.TemplateStore
import net.opentechnology.triki.modules.ContentValidator

@Path("/content")
@MultipartConfig(location="/tmp", fileSizeThreshold=1000000, maxFileSize=50000L, maxRequestSize=100000000L)
public class ContentResource extends RenderResource {
	public static final String CONTENT_PATH = "/content";
	
	@Inject
	private MediaTypeDto mediaDto;
	
	@Inject
	private CachedPropertyStore propStore;
	
	@Inject
	private CoreModule coreModule;
	
	@Inject
	private ContentDto contentDto;
	
	@Inject
	private GroupDto groupDto;
	
	@Inject
	private MediaTypeDto mediaTypeDto;
	
	@Inject @Qualifier("webContentUtils")
	private ContentUtils webContentUtils;
	
	@Inject
	private TemplateStore templateStore;
	
	@Inject
	private AuthorisationManager authMgr;
	
	@Inject
	private ApplicationContext ctx;
	
	@GET
	@Path("upload")
	@Produces(TrikiMediaTypes.HTML_UTF8)
	public String getGraph() throws ResourceException, TemplateException, ExpanderException{
		ST template = templateStore.getTemplate("upload");
	
		def groups = groupDto.getGroups();
		template.add("groups", groups)
		
		String rendered = template.render();
		
		return rendered;
	}
	
	@GET 
	@Path("/{id}")
	public Response getGeneric(@PathParam("id") String id, @QueryParam("action") String action, 
			@FormParam("content") String content, @Context HttpServletResponse resp) throws ResourceException{
		String suffix = id.replaceAll("^.*\\.", "").toLowerCase();
		Object rendered="";
		
		ContentModel model = ctx.getBean("contentModel", ContentModel.class);
		if(action == null)
		{
			String mediaType = mediaDto.getMediaTypeForSuffix(suffix);
			resp.setContentType(mediaType);
			if(mediaType.toLowerCase().contains("text"))
			{
				rendered = webContentUtils.getClasspathTextContent(id);
			}
			else
			{
				rendered = webContentUtils.getClasspathByteContent(id);
			}
		}
		else if (action == ContentModel.ContentAction.edit.name())
		{
			ST template = templateStore.getTemplate("content");
			model.content = model.escapeContent(webContentUtils.getClasspathTextContent(id))
			model.path = "/content/${id}"
			template.add("model", model);
			
			rendered = template.render();

		}
		else if (action == ContentModel.ContentAction.apply.name())
		{
			webContentUtils.writeContent(id, content);
			ST template = templateStore.getTemplate("content");
			model.content = model.escapeContent(webContentUtils.getClasspathTextContent(id))
			model.path = "/content/${id}"
			template.add("model", model);
			model.msgs << "Successfully updated ${id}."
			
			rendered = template.render();

		}
		
		CacheControl cc = new CacheControl();
		cc.setMaxAge(Integer.parseInt(mediaTypeDto.getMaxageForSuffix(suffix)));
		cc.setPrivate(true);
		
		ResponseBuilder builder = Response.ok(rendered);
		builder.cacheControl(cc);
		return builder.build();
	}
			
	@POST
	@Path("/{id}")
	public Object save(@PathParam("id") String id, 
			@FormParam("action") String action,
			@FormParam("content") String content, @Context HttpServletResponse resp) throws ResourceException{
		String suffix = id.replaceAll("^.*\\.", "").toLowerCase();
		ContentModel model = ctx.getBean("contentModel", ContentModel.class);
		if (action.toLowerCase() == ContentModel.ContentAction.save.name())
		{
			validateContent(suffix, content, model, id)
			if(model.errors.size() == 0)
			{
				webContentUtils.writeContent(id, model.unEscapeContent(content));
				if(suffix == "stg")
				{
					templateStore.reinitSiteTemplate()
					model.msgs << "Reinitialised site template."
				}
				model.msgs << "Successfully updated ${id}."
				model.content = model.escapeContent(webContentUtils.getClasspathTextContent(id))
			}
		}
		else if (action.toLowerCase() == ContentModel.ContentAction.validate.name())
		{
			validateContent(suffix, content, model, id)
			model.content = content
		}
		
		ST template = templateStore.getTemplate("content");
		
		model.path = "/content/${id}"
		template.add("model", model);
		String rendered = template.render();
		
		return rendered;
	}

	private validateContent(String suffix, String content, ContentModel model, String id) {
		ContentValidator validator = coreModule.contentValidators."${suffix}"
		if(validator != null)
		{
			validator.validate(content, model.errors)
			if(model.errors.size() == 0)
			{
				model.msgs << "Successfully validated ${id}."
			}
			else
			{
				model.errors << "Problems validating ${id}."
			}		
		}
		else
		{
			model.msgs << "No validator at present for type ${suffix}."
		}
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public ContentModel saveContent(MultipartBody body, @Context HttpServletResponse resp) throws ResourceException{
		ContentModel model = ctx.getBean("contentModel", ContentModel.class);
		model.addFormData(body.getAllAttachments())
		
		if(model.errors.size() == 0)
		{
			model.contentFiles.each { ContentFile contentFile ->
				if(coreModule.getContentValidators().containsKey(contentFile.suffix)){
					ContentValidator validator = coreModule.getContentValidators().get(contentFile.suffix)
					StringWriter writer = new StringWriter();
					IOUtils.copy(contentFile.inputStream, writer, "UTF-8");
					String content = writer.toString()
					validator.validate(content, model.errors);
					if(model.errors.size() == 0)
					{
						model.msgs << "Successfully validated file ${contentFile.filename}"
						webContentUtils.writeContent(contentFile.filename, content)
						generateResource(contentFile, model.access)
						model.msgs << "Successfully uploaded file ${contentFile.filename} with group access ${model.access}"
					}
				}
				else {
					if(coreModule.contentSavers.containsKey(contentFile.suffix)){
						coreModule.contentSavers.get(contentFile.suffix).saveContent(contentFile.filename, contentFile.inputStream, model.msgs, model.errors, model.access)
					}
					else
					{
						webContentUtils.writeStream(contentFile.filename, contentFile.inputStream)
						generateResource(contentFile, model.access)
					}
					model.msgs << "Successfully uploaded file ${contentFile.filename} with group access ${model.access}"
				}
			}
		}
		
		return model;
	}
	
	@Path("response")
	@POST
	@Produces(TrikiMediaTypes.HTML_UTF8)
	public String getContentResponse(@Context HttpServletRequest req) throws ResourceException, TemplateException, ExpanderException{
		ContentModel contentModel = req.getAttribute("resp")
		
		ST template = templateStore.getTemplate("upload");
		template.add("contentModel", contentModel);
		
		def groups = groupDto.getGroups();
		template.add("groups", groups)
		
		String rendered = template.render();
		
		return rendered;
	}
	
	private void generateResource(ContentFile contentFile, String access)
	{
		contentDto.addContentWithGroup(contentFile.filename, access)
	}
	
	private boolean allowedAccess(String id)
	{
		String url = webContentUtils.getUrlForId(id)
		return authMgr.allowAccess(url)
	}

}
