<%@ include file="/WEB-INF/views/common/jstl.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<c:url value="/resources" var="cssroot" />
        <div class="row">
            <div class="col-sm-12 ">
                <div class="row d-flex justify-content-center">
                    <div class="card mt-5">
                        <div class="card-header">
                            <h2> <i class="fas fa-plus"></i> <strong>Cập nhật loại dịch vụ</strong> </h2>
                        </div>
                        <div class="card-body">
                            <div class="card card-light">
                                <div class="card-header">
                                    <h3 class="card-title">Bảng cập nhật</h3>
                                </div>
                                <!-- /.card-header -->
                                <!-- form start -->
                                <f:form action="/admin/servicetype/update" modelAttribute="serviceFee" method="POST" enctype="multipart/form-data">
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="nameoftype">Tên loại dịch vụ</label>
                                            <f:input path="name" class="form-control" placeholder="Enter  Name"/>
                                             <f:hidden path="id"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputPassword1">Phí đặt sân (%)</label>
                                            <f:input path="booking_Fee" class="form-control" placeholder="Enter Book Fee"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="exampleInputFile">Hình Ảnh</label>
                                            <div class="input-group">
                                                <div class="custom-file">
                                                    <input type="file" class="custom-file-input" name="file" >
                                                    <label class="custom-file-label" for="exampleInputFile">Chọn hình ảnh</label>
                                                </div>
                                                <div class="input-group-append">
                                                    <span class="input-group-text" id="">Upload</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.card-body -->

                                    <div class="card-footer">
                                        <button type="submit" name="action" value="save" style="border: 1px solid black;" class="btn"> <i
                                                class="fas fa-plus"></i>&nbspLưu</button>
                                        <button type="submit" name="action" value="cancel" style="border: 1px solid black;" class="btn"><i
                                                class="far fa-window-close"></i>&nbspHủy</button>
                                    </div>
                                </f:form>
                            </div>
                        </div>
                        <div class="card-footer">

                        </div>
                    </div>
                </div>
            </div>
        </div>