/* CVS $Id: $ */
package net.opentechnology.triki.schema; 
import org.apache.jena.rdf.model.*;
import org.apache.jena.ontology.*;
 
/**
 * Vocabulary definitions from src/main/resources/rdf/foaf.rdf 
 * @author Auto-generated by schemagen on 28 May 2019 14:26 
 */
public class Foaf {
    /** <p>The ontology model that holds the vocabulary terms</p> */
    private static OntModel m_model = ModelFactory.createOntologyModel( OntModelSpec.OWL_MEM, null );
    
    /** <p>The namespace of the vocabulary as a string</p> */
    public static final String NS = "http://xmlns.com/foaf/0.1/";
    
    /** <p>The namespace of the vocabulary as a string</p>
     *  @see #NS */
    public static String getURI() {return NS;}
    
    /** <p>The namespace of the vocabulary as a resource</p> */
    public static final Resource NAMESPACE = m_model.createResource( NS );
    
    /** <p>Indicates an account held by this agent.</p> */
    public static final ObjectProperty account = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/account" );
    
    /** <p>Indicates a homepage of the service provide for this online account.</p> */
    public static final ObjectProperty accountServiceHomepage = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/accountServiceHomepage" );
    
    /** <p>An AIM chat ID</p> */
    public static final ObjectProperty aimChatID = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/aimChatID" );
    
    /** <p>A location that something is based near, for some broadly human notion of 
     *  near.</p>
     */
    public static final ObjectProperty based_near = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/based_near" );
    
    /** <p>A current project this person works on.</p> */
    public static final ObjectProperty currentProject = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/currentProject" );
    
    /** <p>A depiction of some thing.</p> */
    public static final ObjectProperty depiction = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/depiction" );
    
    /** <p>A thing depicted in this representation.</p> */
    public static final ObjectProperty depicts = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/depicts" );
    
    /** <p>The underlying or 'focal' entity associated with some SKOS-described concept.</p> */
    public static final ObjectProperty focus = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/focus" );
    
    /** <p>An organization funding a project or person.</p> */
    public static final ObjectProperty fundedBy = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/fundedBy" );
    
    /** <p>Indicates an account held by this agent.</p> */
    public static final ObjectProperty holdsAccount = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/holdsAccount" );
    
    /** <p>A homepage for some thing.</p> */
    public static final ObjectProperty homepage = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/homepage" );
    
    /** <p>An ICQ chat ID</p> */
    public static final ObjectProperty icqChatID = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/icqChatID" );
    
    /** <p>An image that can be used to represent some thing (ie. those depictions which 
     *  are particularly representative of something, eg. one's photo on a homepage).</p>
     */
    public static final ObjectProperty img = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/img" );
    
    /** <p>A page about a topic of interest to this person.</p> */
    public static final ObjectProperty interest = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/interest" );
    
    /** <p>A document that this thing is the primary topic of.</p> */
    public static final ObjectProperty isPrimaryTopicOf = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/isPrimaryTopicOf" );
    
    /** <p>A jabber ID for something.</p> */
    public static final ObjectProperty jabberID = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/jabberID" );
    
    /** <p>A person known by this person (indicating some level of reciprocated interaction 
     *  between the parties).</p>
     */
    public static final ObjectProperty knows = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/knows" );
    
    /** <p>A logo representing some thing.</p> */
    public static final ObjectProperty logo = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/logo" );
    
    /** <p>Something that was made by this agent.</p> */
    public static final ObjectProperty made = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/made" );
    
    /** <p>An agent that made this thing.</p> */
    public static final ObjectProperty maker = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/maker" );
    
    /** <p>A personal mailbox, ie. an Internet mailbox associated with exactly one owner, 
     *  the first owner of this mailbox. This is a 'static inverse functional property', 
     *  in that there is (across time and change) at most one individual that ever 
     *  has any particular value for foaf:mbox.</p>
     */
    public static final ObjectProperty mbox = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/mbox" );
    
    /** <p>The sha1sum of the URI of an Internet mailbox associated with exactly one 
     *  owner, the first owner of the mailbox.</p>
     */
    public static final ObjectProperty mbox_sha1sum = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/mbox_sha1sum" );
    
    /** <p>Indicates a member of a Group</p> */
    public static final ObjectProperty member = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/member" );
    
    /** <p>An MSN chat ID</p> */
    public static final ObjectProperty msnChatID = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/msnChatID" );
    
    /** <p>An OpenID for an Agent.</p> */
    public static final ObjectProperty openid = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/openid" );
    
    /** <p>A page or document about this thing.</p> */
    public static final ObjectProperty page = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/page" );
    
    /** <p>A project this person has previously worked on.</p> */
    public static final ObjectProperty pastProject = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/pastProject" );
    
    /** <p>A phone, specified using fully qualified tel: URI scheme (refs: http://www.w3.org/Addressing/schemes.html#tel).</p> */
    public static final ObjectProperty phone = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/phone" );
    
    /** <p>The primary topic of some page or document.</p> */
    public static final ObjectProperty primaryTopic = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/primaryTopic" );
    
    /** <p>A link to the publications of this person.</p> */
    public static final ObjectProperty publications = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/publications" );
    
    /** <p>A homepage of a school attended by the person.</p> */
    public static final ObjectProperty schoolHomepage = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/schoolHomepage" );
    
    /** <p>A theme.</p> */
    public static final ObjectProperty theme = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/theme" );
    
    /** <p>A derived thumbnail image.</p> */
    public static final ObjectProperty thumbnail = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/thumbnail" );
    
    /** <p>A tipjar document for this agent, describing means for payment and reward.</p> */
    public static final ObjectProperty tipjar = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/tipjar" );
    
    /** <p>A topic of some page or document.</p> */
    public static final ObjectProperty topic = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/topic" );
    
    /** <p>A thing of interest to this person.</p> */
    public static final ObjectProperty topic_interest = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/topic_interest" );
    
    /** <p>A weblog of some thing (whether person, group, company etc.).</p> */
    public static final ObjectProperty weblog = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/weblog" );
    
    /** <p>A work info homepage of some person; a page about their work for some organization.</p> */
    public static final ObjectProperty workInfoHomepage = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/workInfoHomepage" );
    
    /** <p>A workplace homepage of some person; the homepage of an organization they 
     *  work for.</p>
     */
    public static final ObjectProperty workplaceHomepage = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/workplaceHomepage" );
    
    /** <p>A Yahoo chat ID</p> */
    public static final ObjectProperty yahooChatID = m_model.createObjectProperty( "http://xmlns.com/foaf/0.1/yahooChatID" );
    
    /** <p>Indicates the name (identifier) associated with this online account.</p> */
    public static final DatatypeProperty accountName = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/accountName" );
    
    /** <p>The age in years of some agent.</p> */
    public static final DatatypeProperty age = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/age" );
    
    /** <p>The birthday of this Agent, represented in mm-dd string form, eg. '12-31'.</p> */
    public static final DatatypeProperty birthday = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/birthday" );
    
    /** <p>A checksum for the DNA of some thing. Joke.</p> */
    public static final DatatypeProperty dnaChecksum = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/dnaChecksum" );
    
    /** <p>The family name of some person.</p> */
    public static final DatatypeProperty familyName = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/familyName" );
    
    /** <p>The family name of some person.</p> */
    public static final DatatypeProperty family_name = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/family_name" );
    
    /** <p>The first name of a person.</p> */
    public static final DatatypeProperty firstName = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/firstName" );
    
    /** <p>A textual geekcode for this person, see http://www.geekcode.com/geek.html</p> */
    public static final DatatypeProperty geekcode = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/geekcode" );
    
    /** <p>The gender of this Agent (typically but not necessarily 'male' or 'female').</p> */
    public static final DatatypeProperty gender = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/gender" );
    
    /** <p>The given name of some person.</p> */
    public static final DatatypeProperty givenName = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/givenName" );
    
    /** <p>The given name of some person.</p> */
    public static final DatatypeProperty givenname = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/givenname" );
    
    /** <p>The last name of a person.</p> */
    public static final DatatypeProperty lastName = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/lastName" );
    
    /** <p>A Myers Briggs (MBTI) personality classification.</p> */
    public static final DatatypeProperty myersBriggs = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/myersBriggs" );
    
    /** <p>A name for some thing.</p> */
    public static final DatatypeProperty name = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/name" );
    
    /** <p>A short informal nickname characterising an agent (includes login identifiers, 
     *  IRC and other chat nicknames).</p>
     */
    public static final DatatypeProperty nick = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/nick" );
    
    /** <p>A .plan comment, in the tradition of finger and '.plan' files.</p> */
    public static final DatatypeProperty plan = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/plan" );
    
    /** <p>A sha1sum hash, in hex.</p> */
    public static final DatatypeProperty sha1 = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/sha1" );
    
    /** <p>A Skype ID</p> */
    public static final DatatypeProperty skypeID = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/skypeID" );
    
    /** <p>A string expressing what the user is happy for the general public (normally) 
     *  to know about their current activity.</p>
     */
    public static final DatatypeProperty status = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/status" );
    
    /** <p>The surname of some person.</p> */
    public static final DatatypeProperty surname = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/surname" );
    
    /** <p>Title (Mr, Mrs, Ms, Dr. etc)</p> */
    public static final DatatypeProperty title = m_model.createDatatypeProperty( "http://xmlns.com/foaf/0.1/title" );
    
    /** <p>Indicates the class of individuals that are a member of a Group</p> */
    public static final AnnotationProperty membershipClass = m_model.createAnnotationProperty( "http://xmlns.com/foaf/0.1/membershipClass" );
    
    /** <p>An agent (eg. person, group, software or physical artifact).</p> */
    public static final OntClass Agent = m_model.createClass( "http://xmlns.com/foaf/0.1/Agent" );
    
    /** <p>A document.</p> */
    public static final OntClass Document = m_model.createClass( "http://xmlns.com/foaf/0.1/Document" );
    
    /** <p>A class of Agents.</p> */
    public static final OntClass Group = m_model.createClass( "http://xmlns.com/foaf/0.1/Group" );
    
    /** <p>An image.</p> */
    public static final OntClass Image = m_model.createClass( "http://xmlns.com/foaf/0.1/Image" );
    
    /** <p>A foaf:LabelProperty is any RDF property with texual values that serve as 
     *  labels.</p>
     */
    public static final OntClass LabelProperty = m_model.createClass( "http://xmlns.com/foaf/0.1/LabelProperty" );
    
    /** <p>An online account.</p> */
    public static final OntClass OnlineAccount = m_model.createClass( "http://xmlns.com/foaf/0.1/OnlineAccount" );
    
    /** <p>An online chat account.</p> */
    public static final OntClass OnlineChatAccount = m_model.createClass( "http://xmlns.com/foaf/0.1/OnlineChatAccount" );
    
    /** <p>An online e-commerce account.</p> */
    public static final OntClass OnlineEcommerceAccount = m_model.createClass( "http://xmlns.com/foaf/0.1/OnlineEcommerceAccount" );
    
    /** <p>An online gaming account.</p> */
    public static final OntClass OnlineGamingAccount = m_model.createClass( "http://xmlns.com/foaf/0.1/OnlineGamingAccount" );
    
    /** <p>An organization.</p> */
    public static final OntClass Organization = m_model.createClass( "http://xmlns.com/foaf/0.1/Organization" );
    
    /** <p>A person.</p> */
    public static final OntClass Person = m_model.createClass( "http://xmlns.com/foaf/0.1/Person" );
    
    /** <p>A personal profile RDF document.</p> */
    public static final OntClass PersonalProfileDocument = m_model.createClass( "http://xmlns.com/foaf/0.1/PersonalProfileDocument" );
    
    /** <p>A project (a collective endeavour of some kind).</p> */
    public static final OntClass Project = m_model.createClass( "http://xmlns.com/foaf/0.1/Project" );
    
}
