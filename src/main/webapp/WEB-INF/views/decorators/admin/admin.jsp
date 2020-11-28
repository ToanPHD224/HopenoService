<%@ include file="/WEB-INF/views/common/jstl.jsp"%>
<c:url value="/resources/admin" var="cssroot" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 3 | Dashboard</title>

<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${cssroot}/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<!-- <link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"> -->
<!-- Tempusdominus Bbootstrap 4 -->
<link rel="stylesheet"
	href="${cssroot}/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${cssroot}/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- JQVMap -->
<link rel="stylesheet" href="${cssroot}/plugins/jqvmap/jqvmap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${cssroot}/dist/css/adminlte.min.css">
<!-- overlayScrollbars -->
<link rel="stylesheet" href="${cssroot}/plugins/summernote/summernote-bs4.css">
<link rel="stylesheet"
	href="${cssroot}/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
	
	<link rel="stylesheet"
	href="${cssroot}/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
	<link rel="stylesheet"
	href="${cssroot}/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<!-- Daterange picker -->
<link rel="stylesheet"
	href="${cssroot}/plugins/daterangepicker/daterangepicker.css">
<!-- summernote -->
<link rel="stylesheet"
	href="${cssroot}/plugins/summernote/summernote-bs4.css">
<!-- Google Font: Source Sans Pro -->
<!-- <link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet"> -->
		<script src="${cssroot}/plugins/jquery/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="${cssroot}/plugins/jquery-ui/jquery-ui.min.js"></script>
</head>
<body  class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
	<%@ include file="header.jsp"%>
	<%@ include file="aside.jsp" %>

	 <div class="content-wrapper" style="background-color: #3b5998">
	 <div class="container">
	 	<sitemesh:write property='body' />	
	  </div>
	</div>

	<%@ include file="footer.jsp"%>
</div>
	<!-- jQuery -->

	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button)
	</script>
	<!-- Bootstrap 4 -->
	<script src="${cssroot}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- ChartJS -->
	<script src="${cssroot}/plugins/chart.js/Chart.min.js"></script>
	
	<!-- Sparkline -->
	<script src="${cssroot}/plugins/sparklines/sparkline.js"></script>
	<!-- JQVMap -->
	<script src="${cssroot}/plugins/jqvmap/jquery.vmap.min.js"></script>
	<script src="${cssroot}/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="${cssroot}/plugins/jquery-knob/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script src="${cssroot}/plugins/moment/moment.min.js"></script>
	<script src="${cssroot}/plugins/daterangepicker/daterangepicker.js"></script>

	<!-- Tempusdominus Bootstrap 4 -->
	<script
		src="${cssroot}/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
	<!-- Summernote -->
	<script src="${cssroot}/plugins/summernote/summernote-bs4.min.js"></script>
	<!-- overlayScrollbars -->
	<script src="${cssroot}/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
	<script src="${cssroot}/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="${cssroot}/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script src="${cssroot}/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script src="${cssroot}/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${cssroot}/dist/js/adminlte.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="${cssroot}/dist/js/pages/dashboard.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="${cssroot}/dist/js/demo.js"></script>
	<script src="${cssroot}/plugins/summernote/summernote-bs4.min.js"></script>
		<script src="${cssroot}/plugins/chart.js/hightchart.js"></script>
	
</body>
</html>