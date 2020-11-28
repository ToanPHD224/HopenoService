   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/resources" var="cssroot" />
    <div class="row">
    </div>
    <div class="row mt-3" >
        
            <div class="row" >
              <div class="col-sm-12">
                    
                <div class="card">
                  <div class="card-header  font-weight-bold ">
                   <div class="row">
                     <div class="col-sm-3">
                      Thông tin 
                     </div>
                     <div class="col-sm-9">
                          <form action="/admin/service/action" class="form-group" method="POST">

                            <input type="hidden" name="id" value="${service.id}">
                           <c:choose>
                             <c:when test="${service.banned == false }">
                               <button style=" background-color: white;" type="submit" class=" float-right rounded"><i class="fab fa-bandcamp" onclick="confirm()" ></i> Disable </button>
                             </c:when>
                             <c:when test="${service.banned == true }">
                               <button style=" background-color: white;" type="submit" class=" float-right rounded"><i class="fab fa-monero" onclick="confirm()" ></i> Enable </button>
                             </c:when>
                           </c:choose>
                          </form>
                     </div>
                   </div>
                  </div><!-- /.card-header -->
                  <div class="card-body" style="height: auto;">
                    <div class="tab-content">
      
                      <!-- /.tab-pane -->
                      <div class="active tab-pane" id="activity">
                        <!-- The timeline -->
                     
                          <!-- timeline time label -->
                          
                             <div class="row">
                                 
                                 <div class="col-sm-6 ">
                                     
                                  <img width="100%" height="100%" class="rounded" src="${cssroot}/image/admin/${service.image}" alt="aaa">
                                 </div>
                                 <div class="col-sm-6">
                                 
                                 <div class="row mt-2">
                                 
                                  <div class="col-sm-12">
                                      <p><i class="fas fa-home"></i> Địa chỉ : ${service.address}  </p>
                                     
                                     
      
                                  </div>
                                 
                      
                                 </div>
                                 <hr>
                                 <div class="row">
                                 
                                  <div class="col-sm-6">
                                      <p>  <i class="fas fa-snowflake"></i> Tên phường : ${service.ward.name}  </p>
                                     
                                     
      
                                  </div>
                                  <div class="col-sm-6">
                                     
                                    
                                      <p><i class="fas fa-snowflake"></i> Tên Quận : ${service.ward.districs.name}  </p>
                                     
      
                                  </div>
                      
                                 </div>
                                 <hr>
                                 <div class="row">
                                     <div class="col-sm-12">
                                      <h5 class="font-weight-bold font-italic"><i class="fas fa-soap "></i>  Tên dịch vụ: ${service.name}</h5>
                                     </div>
                                     <hr>
                                  <div class="col-sm-12">
      
                                  <p class="font-weight-bold p-2"><i class="fas fa-street-view" style="color: green;"></i> Số người xem: ${service.viewer}</p>
      
                              </div>
      
                              <div class="col-sm-12">
                                  <p class="font-weight-bold p-2"><i  class="fas fa-allergies" style="color: blue"></i> 
                                      Phí trung bình : ${avgFee}</p>
                              </div>
                              <div class="col-sm-12">
                                  <p class="font-weight-bold p-2"><i class="fas fa-ban " style="color: red;"></i> 
                                     Banned : <c:choose>
                                             <c:when test="${service.banned == true}">
                                               
                                               Yes
                                               
                                             </c:when>
                                             <c:when test="${service.banned == false}">
                                               
                                               No
                                               
                                             </c:when>
                                             
                                           </c:choose> 
                                       
                                     
                                     
                                      </p>
                              </div>
      
                              </div>
                                
                                 </div>
                             </div>
                             <hr>
                             <div class="row">
                              <div class="col-sm-12">
                                  <p class="font-italic"> Nội dung:  ${service.content}</p>
                              </div>
                              
      
                             </div>
                             <hr> 
                             <div class="row">
                         
                              <div class="col-sm-12 " >
    
                                <!-- Profile Image -->  
                                <div class="row"> 
                                  <div class="col-sm-6">
                                    <div class="card ">
                                      <div class="card-header font-weight-bold">
                                        Account 
                                      </div>
                                      <div class="card-body box-profile">
                                        <div class="text-center">
                                          <img class="profile-user-img img-fluid img-circle" src="${cssroot}/image/admin/${service.account.image}" alt="User profile picture">
                                        </div>
                              
                                        <h3 class="profile-username text-center">${service.account.name}</h3>
                              
                                        <p class="text-muted text-center">${service.account.role.name}</p>
                              
                                        <ul class="list-group list-group-unbordered mb-3">
                                          <li class="list-group-item">     
                                              <b class="font-weight-bold"><i class="fas fa-mail-bulk " style="color: orange;"></i> Email: ${service.mail} </b>          
                                          </li>
                                          <li class="list-group-item">
                                            <b class="font-weight-bold"><i class="fas fa-folder-plus" style="color: orange;"></i> Tổng Service: ${totalService} </b>
                                          </li>
                                        </ul>
                              
                                        <a href="/admin/contact?mail=${service.mail}" class="btn btn-primary btn-block"><b>Liên lạc</b></a>
                                      </div>
                                      <!-- /.card-body -->
                                    </div>
                                  </div>  
                                   <div class="col-sm-6">
                                    <div class="card  " style="height: 96%;" >
                                      <div class="card-header font-weight-bold">
                                      Thông tin Service
                                      </div>
                                      <!-- /.card-header -->
                                      <div class="card-body">
                                    
                          
                                        <div class="row">
                                        
                                        <div class="col-sm-12">
                          
                                            <p class="font-weight-bold"><i class="fas fa-cart-plus"></i> Tổng Book:  ${totalbook} </p>
                          
                                        </div>
                                        <div class="col-sm-12">
                          
                                            <p class="font-weight-bold"><i class="fas fa-cart-plus" ></i> Tổng Phí: ${totalAmout} VND</p>
                          
                                        </div>
                                        <div class="col-sm-12"></div>
                                        <div class="col-sm-12 ">
                          
                                          <div class="row justify-content-center mt-5">
                                            <h1 class="font-weight-bold">  Đánh giá:  ${avgRate} <i style="color: yellow;" class="fas fa-star"></i> </h1> 
                                          </div>
                        
                                      </div>
                                        </div>
                          
                                      </div>
                                  </div>
                           
                                   </div>
                                   
                                  <!-- /.card-body -->
                               
                          
                                <!-- About Me Box -->
                          
                                <!-- /.card -->
                              </div>
                              <div class="row">
                                <div class="card w-100" >
                                  <div class="card-header">
                                      <p class="font-weight-bold ">  Phản Hồi </p>
                        
                        
                                  </div>
                                  <div class="card-body">
                                      <c:if test="${empty listfeedback}">
                                      
                                        <p> Không có phản hồi  </p>
                                      
                                       </c:if>
                                    <c:if test="${not empty listfeedback}">
                                    <c:forEach var="x" items="${listfeedback}">
                                      <div class="post">
                                        <div class="user-block">
                                          <img class="img-circle img-bordered-sm" src="${cssroot}/image/admin/${x.account.image}" alt="user image">
                                          <span class="username">
                                            <a href="#">${x.account.name}</a>
                                            <a href="#" class="float-right btn-tool"><i class="fas fa-times"></i></a>
                                          </span>
                                        
                                            
                                         
                                          <span class="description"> Thời gian - ${x.createdAt }  </span>
                                          
                                         
                                          
                                         
                                          
                                        </div>
                                        <!-- /.user-block -->
                                        <p>
                                          <a href="/admin/feedback/detail?id=${x.id}">${x.detailsfeedback.content}</a>
                                        </p>
                                      </div>
                                      </c:forEach>
                                      </c:if>
                                  </div>
                                  <!-- Post -->
                                
                                  <!-- /.post -->
                        
                                  <!-- Post -->
                           
                                  <!-- /.post -->
                        
                        
                                  <!-- /.post -->
                                </div>
                              </div>
                            </div>
                            
                              
      
                             </div>
                       
                      </div>
                   
                    </div>
                    <!-- /.tab-content -->
                  </div><!-- /.card-body -->
                </div>

              </div>
       
              <!-- /.col -->
             
                
               
               
                <!-- /.nav-tabs-custom -->
              
            
          </div>
       
        <!-- /.col -->
      </div>
