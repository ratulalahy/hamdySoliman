/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.com.hamdy.website.servlets;

import java.com.hamdy.website.dataAccess.LoadData;
import java.com.hamdy.website.entity.PublicationEntity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ratul
 */
//@WebServlet(name = "Publications", urlPatterns = {"/Publications"})
public class Publications extends HttpServlet {

    private ServletContext servletContext;
    private String rootPath;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoadData loadData = new LoadData();
        String dataFilePath = rootPath + "\\data\\publication.xml";
        List<PublicationEntity> allPublications = loadData.loadAllEntityFromXML(dataFilePath);

//Split All Publications
        List<PublicationEntity> patentPublications = new ArrayList<>();
        List<PublicationEntity> journalPublications = new ArrayList<>();
        List<PublicationEntity> conferencePublications = new ArrayList<>();
        List<PublicationEntity> otherPublications = new ArrayList<>();

        for (PublicationEntity perPublication : allPublications) {
            switch (perPublication.getTypeOfPublication().toLowerCase()) {
                case "patent":
                    patentPublications.add(perPublication);
                    break;
                case "journal":
                    journalPublications.add(perPublication);
                    break;
                case "conference":
                    conferencePublications.add(perPublication);
                    break;
                default:
                    otherPublications.add(perPublication);
                    break;
            }
        }

        Map<String, List<PublicationEntity>> allSplitedPublications = new HashMap<>();
        if (!patentPublications.isEmpty()) {
            allSplitedPublications.put("Patent", patentPublications);
        }
        if (!journalPublications.isEmpty()) {
            allSplitedPublications.put("Journal", journalPublications);
        }
        if (!conferencePublications.isEmpty()) {
            allSplitedPublications.put("Conference", conferencePublications);
        }
        if (!otherPublications.isEmpty()) {
            allSplitedPublications.put("Others", otherPublications);
        }
        /*request.setAttribute("patentPublications", patentPublications);
        request.setAttribute("journalPublications", journalPublications);
        request.setAttribute("conferencePublications", conferencePublications);
        request.setAttribute("otherPublications", otherPublications);*/

        request.setAttribute("allPublications", allPublications);
        request.setAttribute("allSplitedPublications", allSplitedPublications);
        request.getRequestDispatcher("publications.jsp").forward(request, response);
        System.out.println(allPublications.size());
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        super.init(config);
        servletContext = config.getServletContext();
        rootPath = servletContext.getRealPath("/");
    }

}
