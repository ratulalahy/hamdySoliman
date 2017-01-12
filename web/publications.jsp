<%-- 
    Document   : publications
    Created on : Jan 7, 2017, 8:38:49 PM
    Author     : Ratul
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@page import="com.hamdy.website.entity.PublicationEntity" %>
<%@page import="com.hamdy.website.entity.AuthorEntity" %>
<!DOCTYPE html>
<html>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Publication by Dr. Hamdy Soliman">
        <meta name="author" content="ratulalahy">

        <title>Publication by Dr. Hamdy Soliman</title>

        <!-- Bootstrap Core CSS -->
        <!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">


        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>

    <body>
        <!-- Navigation -->
        <nav class="navbar navbar-custome navbar-default navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html"><span class="glyphicon glyphicon_extra_padding glyphicon-home"></span>Dr. Hamdy <strong>Soliman</strong></a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="/DrHamdySoliman/Publications"><span class="glyphicon glyphicon_extra_padding glyphicon-pencil"></span>Publication</a>
                        </li>
                        <li>
                            <a href="research.html"><span class="glyphicon glyphicon_extra_padding glyphicon-grain"></span>Research</a>
                        </li>
                        <li>
                            <a href="courses.html"><span class="glyphicon glyphicon_extra_padding glyphicon-blackboard"></span>Courses</a>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="contact.html"><span class="glyphicon glyphicon_extra_padding glyphicon-envelope"></span>Contact</a>
                        </li>
                        <!--<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container ">
            <div class="row">
                <div class="col-md-1 left_container">
                </div>
                <div class="col-md-10 center_container">
                    <section >
                        <article class="well well-lg " style="text-align: justify">Dr. Hamdy's work focuses on the <span
                                class="topic_name">Computer Networks</span>, <span class="topic_name">Wireless Sensor Network Application </span>and
                            <span class="topic_name">Neural Network Application</span>. <br>His work spans <span
                                class="topic_name">Mobile WSNs</span>, <span class="topic_name">Wireless Networks Security Protocols</span>,
                            <span class="topic_name">All-Fiber-Optics Networks(AFOP) Admission Control</span>.
                        </article>
                        <article class="well well-sm text-primary"><span class="lead">Selected Publications </span> <span style="float: right;"> <a
                                    target="_blank" href="https://scholar.google.com/citations?user=AJvh91MAAAAJ">Google Scholar</a></span>
                        </article>
                    </section>

                    <section role="all publications">

                        <table class="table table-hover">
                            <tbody>

                                <c:forEach items="${allSplitedPublications}" var="splitedPublication">
                                <thead> 
                                    <tr>
                                        <th>
                                            <span class="lead text-primary"><h3>${splitedPublication.key}</h3></span>
                                        </th>
                                    </tr>
                                </thead>
                                <c:forEach items="${splitedPublication.value}" var="singlePublication">
                                    <c:set var="publicationCounter" value="1" scope="page" />
                                    <c:set var="idName" value="id_" scope="page" />
                                    <c:set var="publicationCounterName" value="${idName}${publicationCounter}" />
                                    <tr>
                                        <td>
                                            <div class="col-md-12 publication_all_holder">
                                                <span><a target="_blank" href="${singlePublication.uri}">
                                                        <h4>${singlePublication.title}
                                                        </h4>
                                                    </a>
                                                </span>
                                                <c:set var="publication_title" value="${singlePublication.title}"/>
                                                <c:set var="link_name" value="${fn:replace(publication_title, ' ', '_')}" />
                                                <!--${link_name} -->
                                                <!-- authors name -->
                                                <p>
                                                    <c:forEach items="${singlePublication.authors}" var="author">
                                                        <span class="badge_author"> ${author.authorName} </span>&nbsp;
                                                    </c:forEach>
                                                </p>
                                                <!-- publisher and details -->
                                                <p>
                                                    <c:if test="${singlePublication.publisher!=''}">
                                                        <span class="avoidwrap badge_publisher_name">${singlePublication.publisher}</span>
                                                    </c:if>
                                                    <span class="avoidwrap publication_details"> ${singlePublication.publicationDetails}</span>
                                                    <span class="date_of_publication"> ${singlePublication.dateOfPublication}</span>
                                                </p>

                                                <!-- keyword -->
                                                <section>
                                                    <c:forEach items="${singlePublication.keywords}" var="keyword">
                                                        <span class="badge_keyword"> ${keyword} </span>
                                                    </c:forEach>
                                                </section>
                                            </div>
                                        </td>
                                    </tr>
                                    <c:set var="publicationCounter" value="${publicationCounter + 1}" scope="page"/>
                                </c:forEach>
                            </c:forEach>

                            </tbody>
                        </table>
                    </section>

                    <a id="back-to-top" href="#" class="btn btn-default btn-sm back-to-top" role="button"><span class="glyphicon glyphicon-chevron-up"></span></a>

                </div>
                <div class="col-md-1 right_container">
                </div>
            </div>

            <div class="navbar navbar-in">
                <div class="container-fluid">
                    <hr>
                    <!-- Footer -->
                    <footer>
                        <div class="row">
                            <div class="col-lg-12">
                                <p id="footer_content">Copyright &copy; Hamdy Soliman, 2017</p>
                            </div>
                        </div>
                    </footer>
                </div>
            </div>
        </div>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <!-- Include for auto hide javascript -->
        <script src="js/jquery.bootstrap-autohidingnavbar.js"></script>

        <!-- Include Back to top javascript -->
        <script src="js/hover_to_top.js"></script>

        <script>
            $("nav.navbar-fixed-top").autoHidingNavbar();
        </script>
    </body>

</html>
