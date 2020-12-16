<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/bootStrap.jsp"></c:import>
 
</head>
<body>
<c:import url="./template/header.jsp"></c:import>	
  
  

  <!-- Header1 - set the background image for the header in the line below -->
  <header class="py-5 bg-image-full" style="background-image: url('https://hd.sels.co.kr/images/main_bnrimg01.jpg');height: 619px;">
    <img class="img-fluid d-block mx-auto" src="http://placehold.it/200x200&text=Logo" alt="">
     <a href="#" class="btn btn-primary btn-xl rounded-pill mt-5">Learn More</a>
  </header>

  <!-- Content 1 section -->
  <section class="py-5">
    <div class="container">
      <h1>Section Heading</h1>
      <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid, suscipit, rerum quos facilis repellat architecto commodi officia atque nemo facere eum non illo voluptatem quae delectus odit vel itaque amet.</p>
    </div>
  </section>

  <!-- header2 - set the background image for the header in the line below -->
  <div class="py-5 bg-image-full" style="background-image: url('https://unsplash.it/1900/1080?image=1081'); height: 619px;">
    <!-- Put anything you want here! There is just a spacer below for demo purposes! -->
    <div style="height: 200px;"></div>
  </div>

  <!-- Content2 section -->
  <section class="py-5">
    <div class="container">
      <h1>Section Heading</h1>
      <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid, suscipit, rerum quos facilis repellat architecto commodi officia atque nemo facere eum non illo voluptatem quae delectus odit vel itaque amet.</p>
    </div>
  </section>

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		
</body>
</html>