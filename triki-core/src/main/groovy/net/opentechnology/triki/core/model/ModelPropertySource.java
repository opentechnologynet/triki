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

package net.opentechnology.triki.core.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.PropertySource;

import javax.inject.Inject;

import org.apache.jena.rdf.model.Model;

public class ModelPropertySource {

	@Inject	@Qualifier("siteModel")
	private Model model;

	public Object getProperty(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
