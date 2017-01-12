/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.hamdy.website.dataAccess;

import java.com.hamdy.website.entity.AuthorEntity;
import java.com.hamdy.website.entity.PublicationEntity;
import java.com.hamdy.website.utils.TagNames;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Ratul
 */
public class LoadData {

    public List<PublicationEntity> loadAllEntityFromXML(String dataFilePath) {

        List<PublicationEntity> allPublications = new ArrayList<>();
        try {

            //File fXmlFile = new File("F:\\NMT_Course\\Internet Programming\\Programming\\Project\\SurveyWebProgramming\\MyXMLParser\\src\\myxmlparser\\publication.xml");
            File fXmlFile = new File(dataFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName(TagNames.ENTITY_ROOT_TAG);

            for (int temp = 0; temp < nList.getLength(); temp++) {
                PublicationEntity singlePublication = new PublicationEntity();
                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    singlePublication.setTitle(eElement.getElementsByTagName(TagNames.TITLE_TAG).item(0).getTextContent());
                    singlePublication.setUri(eElement.getElementsByTagName(TagNames.URI_TAG).item(0).getTextContent());

                    String tempAuthorsName = eElement.getElementsByTagName(TagNames.AUTHORS_TAG).item(0).getTextContent();
                    List<AuthorEntity> allAuthors = getAllAuthors(tempAuthorsName);
                    singlePublication.setAuthors(allAuthors);

                    singlePublication.setPublisher(eElement.getElementsByTagName(TagNames.PUBLISHER_NAME_TAG).item(0).getTextContent());
                    singlePublication.setPublicationDetails(eElement.getElementsByTagName(TagNames.PUBLICATION_DETAILS_TAG).item(0).getTextContent());
                    singlePublication.setTypeOfPublication(eElement.getElementsByTagName(TagNames.TYPE_OF_PUBLICATION_TAG).item(0).getTextContent());

                    String tempDateString = eElement.getElementsByTagName(TagNames.DATE_OF_PUBLICATION_TAG).item(0).getTextContent();
                    String year = getYearOfPublication(tempDateString);
                    singlePublication.setDateOfPublication(year);

                    String tempKeywords = eElement.getElementsByTagName(TagNames.KEYWORD_PRIMARY_TAG).item(0).getTextContent();
                    List<String> allKeywords = getKeywordList(tempKeywords);
                    singlePublication.setKeywords(allKeywords);
                    /*System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Uri : " + eElement.getElementsByTagName("uri").item(0).getTextContent());
                    System.out.println("Authors : " + eElement.getElementsByTagName("authors").item(0).getTextContent());
                    System.out.println("Publisher : " + eElement.getElementsByTagName("publisher").item(0).getTextContent());

                    System.out.println("Publication details : " + eElement.getElementsByTagName("publication_details").item(0).getTextContent());
                    System.out.println("Type of publication : " + eElement.getElementsByTagName("type_of_publication").item(0).getTextContent());
                    System.out.println("Year of Publication : " + eElement.getElementsByTagName("year_of_publication").item(0).getTextContent());

                    System.out.println("Keyword primary : " + eElement.getElementsByTagName("keyword_primary").item(0).getTextContent());
                    System.out.println("Keyword secondary : " + eElement.getElementsByTagName("keyword_secondary").item(0).getTextContent());

                    System.out.println("-------------------");*/
                    allPublications.add(singlePublication);
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException | DOMException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));

        }
        return allPublications;
    }

    private List<AuthorEntity> getAllAuthors(String _allAuthor) {
        List<AuthorEntity> allAuthors = new ArrayList<>();
        String[] tempAuthorAry = _allAuthor.split(",");

        for (String individual : tempAuthorAry) {
            AuthorEntity author = new AuthorEntity(individual.trim());
            allAuthors.add(author);
        }

        return allAuthors;
    }

    private List<String> getKeywordList(String _allKeywords) {
        List<String> allKeywords = new ArrayList<>();
        String[] tempKeywordAry = _allKeywords.split("[;,]");
        //String[] trimmedKeyword = new String[tempKeywordAry.length];
        for (int i = 0; i < tempKeywordAry.length; i++) {
            tempKeywordAry[i] = tempKeywordAry[i].trim();
            /*if (tempKeywordAry[i] != null) {
                tempKeywordAry[i] = tempKeywordAry[i].replaceAll("^\\s+", "#");
                tempKeywordAry[i] = tempKeywordAry[i].replaceAll("\\s+$", "_");
            }*/

            tempKeywordAry[i] = Character.toUpperCase(tempKeywordAry[i].charAt(0)) + tempKeywordAry[i].substring(1);
        }

        allKeywords.addAll(Arrays.asList(tempKeywordAry));
        return allKeywords;
    }

    private String getYearOfPublication(String _fullDate) {
        String[] tempData = _fullDate.split("/");
        return tempData[0];
    }
}
