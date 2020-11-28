<%@ include file="/WEB-INF/views/common/jstl.jsp" %>
<c:url value="/resources" var="cssroot" />
                <div class="row justify-content-center">    
              <div  class="col-sm-12 ">
                <div class="row d-flex justify-content-center">
              <div  class="card mt-5" style="width: 100%;" >
                <div class="card-header">
                  <h5> <i class="fas fa-info-circle"></i> <strong>Service Feedback</strong> </h5>
                </div>
                <div  class="card-body" >
                  <div class="card card-light">
                      <div class="card-header">
                        <h3 class="card-title">Content Details </h3>
                      </div>
                      <!-- /.card-header -->
                      <!-- form start -->
                  
                        <div class="card-body">
                            ${feedback.content}
                        </div>
                        <!-- /.card-body -->
        
                       
                      
                    </div>
                </div>
                <div class="card-footer">

                </div>
            </div>
          </div>
        </div>
                </div>

<script>

</script>