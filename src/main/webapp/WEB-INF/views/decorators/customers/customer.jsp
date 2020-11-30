<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/views/common/jstl.jsp"%>
<c:url value="/resources/customer" var="cssroot" />
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <title>Hopeno - Tìm sân thể thao nhanh chóng</title>
      <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
      <meta name="title" content="Hopeno - Tìm sân thể thao nhanh chóng">
      <meta name="author" content="Hopeno">
      <link rel="apple-touch-icon" sizes="120x120" href="${cssroot}/assets/img/favicon/apple-touch-icon.png">
      <link rel="icon" type="image/png" sizes="32x32" href="${cssroot}/assets/img/favicon/favicon-32x32.png">
      <link rel="icon" type="image/png" sizes="16x16" href="${cssroot}/assets/img/favicon/favicon-16x16.png">
      <link rel="manifest" href="${cssroot}/assets/img/favicon/site.webmanifest">
      <link rel="mask-icon" href="${cssroot}/assets/img/favicon/safari-pinned-tab.svg" color="#ffffff">
      <meta name="msapplication-TileColor" content="#ffffff">
      <meta name="theme-color" content="#ffffff">
      <link type="text/css" href="${cssroot}/vendor/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">
      <link type="text/css" href="${cssroot}/vendor/leaflet/dist/leaflet.css" rel="stylesheet">
      <link rel="stylesheet" href="${cssroot}/vendor/@fancyapps/fancybox/dist/jquery.fancybox.min.css">
      <link rel="stylesheet" href="${cssroot}/vendor/jqvmap/dist/jqvmap.min.css">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-timepicker/1.13.16/jquery.timepicker.min.css">
      <link type="text/css" href="${cssroot}/css/spaces.css" rel="stylesheet">
   </head>
  <body>
	<%@ include file="header.jsp" %>
	
    
	 <sitemesh:write property='body'/>
	 
	 
	<%@ include file="footer.jsp" %>  
	  
	  <script src="${cssroot}/vendor/jquery/dist/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timepicker/1.13.16/jquery.timepicker.min.js"></script>
      <script src="${cssroot}/vendor/popper.js/dist/umd/popper.min.js"></script>
      <script src="${cssroot}/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
      <script src="${cssroot}/vendor/headroom.js/dist/headroom.min.js"></script>
      <script src="${cssroot}/vendor/onscreen/dist/on-screen.umd.min.js"></script>
      <script src="${cssroot}/vendor/nouislider/distribute/nouislider.min.js"></script>
      <script src="${cssroot}/vendor/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
      <script src="${cssroot}/vendor/waypoints/lib/jquery.waypoints.min.js"></script>
      <script src="${cssroot}/vendor/owl.carousel/dist/owl.carousel.min.js"></script>
      <script src="${cssroot}/vendor/smooth-scroll/dist/smooth-scroll.polyfills.min.js"></script>
      <script src="${cssroot}/vendor/@fancyapps/fancybox/dist/jquery.fancybox.min.js"></script>
      <script src="${cssroot}/vendor/sticky-sidebar/dist/sticky-sidebar.min.js"></script>
      <script src="${cssroot}/vendor/leaflet/dist/leaflet.js"></script>
      <script src="${cssroot}/vendor/chartist/dist/chartist.min.js"></script>
      <script src="${cssroot}/vendor/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
      <script src="${cssroot}/vendor/jqvmap/dist/jquery.vmap.min.js"></script>
      <script src="${cssroot}/vendor/jqvmap/dist/maps/jquery.vmap.usa.js"></script>
      <script src="${cssroot}/assets/js/jquery.slideform.js"></script>
      <script src="${cssroot}/assets/js/spaces.js"></script>
  </body>
</html>