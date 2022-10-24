<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://kit.fontawesome.com/0fe1b51407.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <style>
            .card{
                height: 650px;
            }
            .card-img-top{
                width: 100%;
                height: 356px;
                border-top-left-radius: calc(0.25rem - 1px);
                border-top-right-radius: calc(0.25rem - 1px);
            }
            .pagination {
                float: right;
                margin: 10px;
            }
            .navbar{
                background-color: #2a3d4c;
                font-family: 'Poppins';
                font-weight: 400;
                font-size: 22px;
                margin-bottom: 20px;
            }
            .jumbotron{
                padding: 0;
                background-color: white;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Menu.jsp"></jsp:include>
            <section class="jumbotron text-center">
                <img src="https://scontent.fhan14-3.fna.fbcdn.net/v/t39.30808-6/270151859_1739706846226058_4391024343800653055_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=8631f5&_nc_ohc=sjxw98dtVicAX9wtmic&_nc_ht=scontent.fhan14-3.fna&oh=00_AT8V-VUrz8EEQjQTAhkQeRvM18xQ-1nPkstfRnQzhSwDgQ&oe=635B4DD9" 
                     width="100%" height="100%" alt="">
                <div class="container">
                    <h1 class="jumbotron-heading">DUT</h1>
                    <p class="lead text-muted mb-0">Dũng Cảm - Ứng Biến - Tin Cậy</p>
                </div>
            </section>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                <jsp:include page="Left.jsp"></jsp:include>
                </div>

                <div class="col-sm-9">
                    <div class="row">
                    <c:forEach items="${listP}" var="o">
                        <div class="col-12 col-md-6 col-lg-4">
                            <div class="card">
                                <a href="detail?pid=${o.id}" title="View Product"><img class="card-img-top" src="${o.image}" alt="Card image cap"></a>
                                <div class="card-body">
                                    <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                    <p class="card-text show_txt">${o.title}</p>
                                    <div class="row">
                                        <div class="col">
                                            <p class="btn btn-danger btn-block">${o.price}K</p>
                                        </div>
                                        <div class="col">
                                            <a href="detail?pid=${o.id}" class="btn btn-success btn-block">BUY NOW</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </div>
        <div class="clearfix">
            <ul class="pagination">
                <c:if test="${tag1 > 1}">
                    <li class="page-item"><a href="home?index=${tag1-1}" class="page-link">Previous</a></li>
                    </c:if>
                    <c:forEach begin="1" end="${endP}" var="i">
                    <li class="page-item ${tag1 == i?"active":""}"><a href="home?index=${i}" class="page-link">${i}</a></li>
                    </c:forEach>
                    <c:if test="${tag1<endP}">
                    <li class="page-item"><a href="home?index=${tag1+1}" class="page-link">Next</a></li>
                    </c:if>

            </ul>
        </div>
        <jsp:include page="Footer.jsp"></jsp:include>                
    </body>
</html>

