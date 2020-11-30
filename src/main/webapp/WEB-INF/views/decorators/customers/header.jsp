<%@ include file="/WEB-INF/views/common/jstl.jsp"%>
<c:url value="/resources/customer" var="cssroot" />
<%@ page contentType="text/html; charset=UTF-8" %>

      <header class="header-global">
         <nav id="navbar-main" class="navbar navbar-main navbar-theme-primary navbar-expand-lg headroom py-lg-3 px-lg-6 navbar-dark navbar-transparent navbar-theme-primary">
            <div class="container">
               <a class="navbar-brand @@logo_classes" href="${cssroot}/index.html">
                <img class="navbar-brand-dark common" src="${cssroot}/assets/img/brand/light.svg" height="35" alt="Logo light">
                <img class="navbar-brand-light common" src="${cssroot}/assets/img/brand/dark.svg" height="35" alt="Logo dark">
                </a>
               <div class="d-none d-lg-block @@cta_button_classes">
                <a href="#" target="_blank" class="btn btn-md btn-outline-white animate-up-2 mr-3">
                  <i class="fas fa-book mr-1"></i>
                  <span class="d-none d-xl-inline">Dành cho chủ sân</span>
                </a>
                <a href="#" target="_blank" class="btn btn-md btn-secondary animate-up-2">
                  <i class="fas fa-shopping-bag mr-2"></i> Đăng nhập</a></div>
               <div class="d-flex d-lg-none align-items-center"><button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button></div>
            </div>
         </nav>
      </header>