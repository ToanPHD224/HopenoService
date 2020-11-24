<%@ include file="/WEB-INF/views/common/jstl.jsp" %>
<c:url value="/resources" var="cssroot" />
                <div class="row">    
              <div  class="col-sm-12 ">
                <div class="row d-flex justify-content-center">
              <div  class="card mt-5" >
                <div class="card-header">
                  <h2> <i class="fas fa-plus"></i> <strong>Add Service Type</strong> </h2>
                </div>
                <div  class="card-body">
                  <div class="card card-light">
                      <div class="card-header">
                        <h3 class="card-title">Register Form</h3>
                      </div>
                      <!-- /.card-header -->
                      <!-- form start -->
                      <form action="/admin/addservicetype" method="POST" enctype="multipart/form-data" >
                        <div class="card-body">
                          <div class="form-group">
                            <label for="nameoftype">Name of Type</label>
                            <input type="text" class="form-control" name="name" placeholder="Enter  Name">
                          </div>
                          <div class="form-group">
                            <label for="exampleInputPassword1">Booking Fee (%)</label>
                            <input type="number" class="form-control" name="bookfee" placeholder="Enter Book Fee">
                          </div>
                          <div class="form-group">
                            <label for="exampleInputFile">Image</label>
                            <div class="input-group">
                              <div class="custom-file">
                                <input type="file" class="custom-file-input" name="file" id="exampleInputFile">
                                <label class="custom-file-label"  for="exampleInputFile">Choose file</label>
                              </div>
                              <div class="input-group-append">
                                <span class="input-group-text" id="">Upload</span>
                              </div>
                            </div>
                          </div>
                        </div>
                        <!-- /.card-body -->
        
                        <div class="card-footer">
                          <button type="submit" style="border: 1px solid black;" name="action" value="save" class="btn"> <i class="fas fa-plus"></i>&nbspSave</button>
                          <button type="submit" style="border: 1px solid black;" name="action" value="cancle" class="btn"><i class="far fa-window-close"></i>&nbspCancel</button>
                        </div>
                      </form>
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