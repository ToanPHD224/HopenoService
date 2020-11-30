

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url value="/resources/customer" var="cssroot" />
<c:url value="/resources/image/service" var="imageLink" />

<%@ page contentType="text/html; charset=UTF-8" %>
<main>
   <section class="section section-header section-image bg-primary overlay-primary text-white pb-4 pb-md-7" data-background="${cssroot}/assets/img/hero-1.jpg">
      <div class="container">
         <div class="row justify-content-center mb-4 mb-xl-5">
            <div class="col-12 col-xl-10 text-center">
               <h1 class="display-2">Tìm sân phù hợp với bạn.</h1>
               <p class="lead text-muted mt-4 px-md-6">
                 <span class="font-weight-bold">1,000+</span> sân chơi thể thao với các loại hình đa dạng.</p>
            </div>
         </div>
         <div class="row mb-5">
            <div class="col-12">
               <div class="card p-md-2">
                  <div class="card-body p-2 p-md-0">
                     <form autocomplete="off" class="row" method="get" action="${cssroot}/all-spaces.html">
                        <div class="col-12 col-lg-5">
                           <div class="form-group form-group-lg mb-lg-0">
                              <div class="input-group">
                                 <div class="input-group-prepend"><span class="input-group-text"><span class="fas fa-map-marker-alt"></span></span></div>
                                 <input id="search-content" type="text" class="form-control autocomplete" placeholder="Tên quận hoặc tên sân" required>
                              </div>
                           </div>
                        </div>
                        <div class="col-12 col-lg-3">
                           <div class="input-group input-group-lg mb-3 mb-lg-0">
                              <div class="input-group-prepend"><span class="input-group-text"><i class="far fa-calendar-alt"></i></span></div>
                              <input class="form-control datepicker" placeholder="Chọn ngày" type="text" required>
                           </div>
                        </div>
                        <div class="col-12 col-lg-2">
                          <div class="input-group input-group-lg mb-3 mb-lg-0">
                             <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-clock"></i></span></div>
                             <input class="form-control timepicker" min="00:00" max="23:30" placeholder="Chọn giờ" type="time" required>
                          </div>
                       </div>
                        <div class="col-12 col-lg-2"><button class="btn btn-lg btn-primary btn-block animate-up-2" type="submit">Tìm kiếm</button></div>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>
   <section class="section section-lg pb-lg-6 pb-5">
      <div class="container">
         <div class="row">
            <div class="col-12 col-sm-6 col-md-4 text-center mb-4 mb-md-0 px-lg-4">
               <img class="img-fluid image-lg mb-4" src="${cssroot}/assets/img/illustrations/easy-transaction.svg" alt="northwestern logo">
               <h2 class="h4">Thật dễ dàng</h2>
               <p>Dễ dàng tìm kiếm sân thể thao gần bạn, với các tùy chọn thời gian và giá cả theo ý muốn.</p>
            </div>
            <div class="col-12 col-sm-6 col-md-4 text-center mb-4 mb-md-0 px-lg-4">
               <img class="img-fluid image-lg mb-4" src="${cssroot}/assets/img/illustrations/support.svg" alt="northwestern logo">
               <h2 class="h4">Bất cứ khi nào</h2>
               <p>Chúng tôi hỗ trợ bạn mọi lúc bằng lượng sân chơi đông đảo trên nền tảng.</p>
            </div>
            <div class="col-12 col-sm-6 col-md-4 text-center mb-4 mb-md-0 px-lg-4">
               <img class="img-fluid image-lg mb-4" src="${cssroot}/assets/img/illustrations/payment.svg" alt="northwestern logo">
               <h2 class="h4">Giá tốt nhất</h2>
               <p>Bạn có thể được lựa chọn những dịch vụ tốt nhất với giá cả hợp lý!</p>
            </div>
         </div>
         <div class="row mt-6">
            <div class="col-12">
               <h3 class="h4 mb-5">Sân thể thao ngẫu nhiên</h3>
            </div>
            <c:forEach var="x" items="${listService}">
            <div class="col-12 col-md-6 col-lg-4">
               <div class="card border-light mb-4 animate-up-5">
                  <a href="${cssroot}/single-space.html" class="position-relative"><img src="${imageLink}/${x.service.image}" class="card-img-top p-2 rounded-xl" alt="themesberg office"></a>
                  <div class="card-body">
                     <a href="${cssroot}/single-space.html">
                        <h4 class="h5" >${x.service.name}</h4>
                     </a>
                     <div class="d-flex my-4">
                  	 <c:forEach var ="i" begin = "0" end = "${x.avgRating -1}">
       					<span class="star fas fa-star text-warning"></span> 
   					   </c:forEach>
                     <span class="badge badge-pill badge-primary ml-2">${x.avgRating}</span>
                     </div>
                     <ul class="list-group mb-3">
                        <li class="list-group-item small p-0"><span class="fas fa-map-marker-alt mr-2"></span>${x.service.address}, ${x.ward.name}, ${x.districs.name}</li>
                     </ul>
                  </div>
                  <div class="card-footer bg-soft border-top">
                     <div class="d-flex justify-content-between">
                        <div class="col pl-0"><span class="text-muted font-small d-block mb-2">Phí Trung Bình</span> <span class="h5 text-dark font-weight-bold">${x.avgFee}</span></div>
                        <div class="col"><span class="text-muted font-small d-block mb-2">Số Sân</span> <span class="h5 text-dark font-weight-bold">${x.sportFiled}</span></div>
                
                     </div>
                  </div>
               </div>
            </div>
   			</c:forEach>
           
          
         </div>
         <div class="row">
            <div class="col mt-lg-6 mt-3 d-flex flex-column text-center">
               <div><a href="${cssroot}/all-spaces.html" class="btn btn-primary animate-up-2 mb-2">Hiển thị tất cả</a></div>
               <span class="small">1 sân chơi ở TP Hồ Chí Minh</span>
            </div>
         </div>
         <div class="row mt-6">
          <div class="col-12">
             <div class="card rounded border border-light">
                <div class="card-body p-3 p-md-5">
                   <div class="progress-wrapper mb-3 mb-md-5">
                      <div class="progress-info info-xl d-block d-md-flex">
                         <div class="progress-label">
                            <h2 class="h4 text-dark">Bạn muốn tăng trưởng doanh thu?</h2>
                         </div>
                         <div><span class="text-gray h4">85%</span></div>
                      </div>
                      <div class="progress progress-lg my-4 my-md-0">
                         <div class="progress-bar bg-primary" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%;"></div>
                      </div>
                   </div>
                   <div class="d-block d-lg-flex flex-column flex-lg-row justify-content-between align-items-center">
                      <div class="mb-5 mb-lg-0">
                         <h4 class="font-weight-normal">Hãy đăng ký để trở thành chủ sân trên nền tảng của chúng tôi ngay!</h4>
                         <p class="lead mb-0">Hopeno giúp bạn lấp đầy những khoảng thời gian trống, dễ dàng quản lý dịch vụ <br class="d-none d-lg-inline"> và khách hàng của mình.</p>
                      </div>
                      <div class="align-content-end"> <button type="button" class="btn btn-primary animate-up-2" data-toggle="modal" data-target="#modal-form">Đăng ký ngay!</button></div>
                      <div class="modal fade" id="modal-form" tabindex="-1" role="dialog" aria-labelledby="modal-form" aria-hidden="true">
                         <div class="modal-dialog modal-dialog-centered modal-md" role="document">
                            <div class="modal-content">
                               <div class="modal-body p-0">
                                  <div class="card bg-soft shadow-md border-0">
                                     <div class="card-header bg-white py-4">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                                        <div class="text-muted text-center mb-1">
                                           <h3>Bạn muốn trở thành chủ sân?</h3>
                                           <p>Chúng tôi rất vui về điều đó. Hãy cho chúng tôi một vài thông tin, chúng tôi sẽ sớm liên hệ lại với bạn để xác thực.</p>
                                        </div>
                                     </div>
                                     <div class="card-body">
                                        <form class="mt-1">
                                           <div class="form-group">
                                              <div class="input-group mb-4">
                                                 <div class="input-group-prepend"><span class="input-group-text"><span class="far fa-user"></span></span></div>
                                                 <input class="form-control" placeholder="Tên của bạn" type="text" required>
                                              </div>
                                           </div>
                                           <div class="form-group">
                                              <div class="input-group mb-4">
                                                 <div class="input-group-prepend"><span class="input-group-text"><span class="far fa-envelope"></span></span></div>
                                                 <input class="form-control" placeholder="Email của bạn" type="email" required>
                                              </div>
                                           </div>
                                           <div class="form-group">
                                              <div class="input-group mb-4">
                                                <div class="input-group-prepend"><span class="input-group-text"><span class="fas fa-address-card"></span></span></div>
                                                <input class="form-control" placeholder="Tên sân" type="text" required>
                                              </div>
                                          </div>
                                          <div class="form-group">
                                            <div class="input-group mb-4">
                                              <div class="input-group-prepend"><span class="input-group-text"><span class="fas fa-sliders-h"></span></span></div>
                                              <select class="custom-select" id="">
                                                 <option>Thể loại</option>
                                                 <option>On-Demand Meeting Spaces</option>
                                                 <option>Office Space</option>
                                              </select>
                                           </div>
                                          </div>
                                          <div class="form-group">
                                            <div class="input-group mb-4">
                                              <div class="input-group-prepend"><span class="input-group-text"><span class="fas fa-map-marker"></span></span></div>
                                              <select class="custom-select" id="">
                                                 <option>Quận</option>
                                                 <option>On-Demand Meeting Spaces</option>
                                                 <option>Office Space</option>
                                              </select>
                                           </div>
                                          </div>
                                          <div class="form-group">
                                            <div class="input-group mb-4">
                                              <div class="input-group-prepend"><span class="input-group-text"><span class="fas fa-map-marker"></span></span></div>
                                              <select class="custom-select" id="">
                                                 <option>Phường</option>
                                                 <option>On-Demand Meeting Spaces</option>
                                                 <option>Office Space</option>
                                              </select>
                                           </div>
                                          </div>
                                          <div class="form-group">
                                            <div class="input-group mb-4">
                                              <div class="input-group-prepend"><span class="input-group-text"><span class="fas fa-map-marker"></span></span></div>
                                              <input class="form-control" placeholder="Địa chỉ" type="text" required>
                                            </div>
                                           </div>
                                          <div class="text-center"><button type="submit" class="btn btn-block btn-primary mt-4">Đăng ký ngay!</button></div>
                                        </form>
                                     </div>
                                  </div>
                               </div>
                            </div>
                         </div>
                      </div>
                   </div>
                </div>
             </div>
          </div>
       </div>
      </div>
   </section>
</main>
<div class="section">
   <div class="container z-2">
      <div class="row position-relative justify-content-center align-items-cente">
         <div class="col-12">
            <div class="card border-light">
               <div class="card-body text-left px-5 py-4">
                  <div class="row align-items-center">
                     <div class="col-md-5">
                        <p class="lead mb-4"><span class="font-weight-bold">+1000</span> sân chơi thể thao trên khắp các quận ở TP Hồ Chí Minh</p>
                        <div class="row mb-4">
                           <div class="col">
                              <ul class="list-group mb-3">
                                 <li class="list-group-item text-gray p-0 mb-2"><a href="#"><span class="fas fa-map-marker-alt mr-2"></span>Quận 1</a></li>
                                 <li class="list-group-item text-gray p-0 mb-2"><a href="#"><span class="fas fa-map-marker-alt mr-2"></span>Quận 2</a></li>
                                 <li class="list-group-item text-gray p-0 mb-2"><a href="#"><span class="fas fa-map-marker-alt mr-2"></span>Quận 3</a></li>
                                 <li class="list-group-item text-gray p-0"><a href="#"><span class="fas fa-map-marker-alt mr-2"></span>Quận 4</a></li>
                              </ul>
                           </div>
                           <div class="col">
                              <ul class="list-group mb-3">
                                 <li class="list-group-item text-gray p-0 mb-2"><a href="#"><span class="fas fa-map-marker-alt mr-2"></span>Quận Bình Thạnh</a></li>
                                 <li class="list-group-item text-gray p-0 mb-2"><a href="#"><span class="fas fa-map-marker-alt mr-2"></span>Quận Tân Bình</a></li>
                                 <li class="list-group-item text-gray p-0 mb-2"><a href="#"><span class="fas fa-map-marker-alt mr-2"></span>Quận Gò Vấp</a></li>
                                 <li class="list-group-item p-0"><a href="${cssroot}/html/all-spaces.html">Xem thêm<span class="fas fa-arrow-right fa-xs ml-2"></span></a></li>
                              </ul>
                           </div>
                        </div>
                     </div>
                     <div class="col-12 col-md-7 mt-5 mt-md-0 text-md-right d-none d-sm-block"><img src="${cssroot}/assets/img/illustrations/world-map.svg" alt=""></div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</div>



