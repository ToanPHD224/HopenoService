<%@ include file="/WEB-INF/views/common/jstl.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/resources/admin" var="cssroot" />
 <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="" class="brand-link">
      <img src="/resources/image/admin/vuvuvu00.gif" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-bold">Hopeno Service</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="${cssroot}/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">${pageContext.request.userPrincipal.name}</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item has-treeview menu-open">
            <a href="/admin/" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
               Trang chủ
             
              </p>
            </a>
          </li>
       
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
           <i class="fas fa-concierge-bell"></i>
              <p>
              &ensp;Dịch Vụ
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/admin/service/getall" class="nav-link">
                &ensp;<i class="fas fa-eye"></i>
                  <p>&ensp;Dịch Vụ</p>
                </a>
              </li>
                <li class="nav-item">
                <a href="/admin/service/register" class="nav-link">
                &ensp; <i class="fas fa-registered"></i>
                  <p>&ensp;Phiếu Đăng Kí</p>
                </a>
              </li>
              <li class="nav-item has-treeview">
                <a href="/admin/service/payment/getbill" class="nav-link">
                 &ensp;<i class="fab fa-paypal"></i>
                  <p>
                    &ensp;  Thanh Toán
                   
                  </p>
                </a>
              </li>
            </ul>
          </li>
      
                 
           <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
       	 	<i class="fas fa-credit-card"></i>
              <p>
              &ensp;Thể Loại Dịch Vụ
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="/admin/servicetype/getall/1" class="nav-link">
                 &ensp;<i class="fas fa-eye"></i>
                  <p>&ensp;Thể Loại Dịch Vụ</p>
                </a>
              </li>
                <li class="nav-item">
                <a href="/admin/servicetype/add" class="nav-link">
              &ensp; <i class="fas fa-plus-circle"></i>
                  <p>&ensp;Thêm Thể Loại Dịch Vụ</p>
                </a>
              </li>
            </ul>
          </li>
          	 <li class="nav-item">
            <a href="/admin/users/getall" class="nav-link">
          <i class="fas fa-address-book"></i>
              <p>&ensp;Người dùng</p>
            </a>
          </li>
              <li class="nav-item">
            <a href="/admin/feedback/getall" class="nav-link">
            <i class="fas fa-comments"></i>
              <p>&ensp;Phản Hồi</p>
            </a>
          </li>
           <li class="nav-item">
            <a href="/admin/contact" class="nav-link">
           <i class="far fa-id-card"></i>
              <p>&ensp;Liên Lạc</p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
