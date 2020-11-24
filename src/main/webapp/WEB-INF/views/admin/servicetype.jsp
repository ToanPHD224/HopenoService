<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/resources" var="cssroot" />
<c:url var="firstUrl" value="/admin/servicetype/1" />
<c:url var="lastUrl" value="/admin/servicetype/${totalPages}" />
<c:url var="prevUrl" value="/admin/servicetype/${currentPageNumber - 1}" />
<c:url var="nextUrl" value="/admin/servicetype/${currentPageNumber + 1}" />
<div class="row">
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">


				<!-- /.col -->
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
</div>
<div class="row justify-content-center">

	<div class="card">
		<div class="card-header">
			<div class="row">
				<div class="col-sm-3">
					<h1 class="card-title mt-2">Service Type</h1>
				</div>
				<div class="col-sm-9">
					<button style="border: none;" id="add"
						class="btn  btn-primary float-right">
						<i class="fas fa-plus"></i>
					</button>
				</div>
			</div>


		</div>

		<div class="card-body">
			<div class="row">
				<c:if test="${not empty listServiceFee }">
					<c:forEach var="x" items="${listServiceFee}">

						<c:choose>

							<c:when test="${size >=3 }">
								
									<div class="col-sm-4">
									<form action="/admin/updatetypeservice" method="GET">
										<div class="card card-success">
											<div class="card-header">
												<h3 class="card-title">${x.name}</h3>
												<input type="hidden" value="${x.id}" name="id" />
												<div class="float-right">
													<button type="submit" name="action" value="update"
														style="border: none; opacity: 0.7;" class="btn-dark"
														data-toggle="modal" data-target="#modalPoll-1">
														<i class="fas fa-wrench"></i>
													</button>
												
													<c:choose>
														<c:when test="${x.status==true }">
															<button type="submit" name="action" value="delete"
															style="border: none; opacity: 0.7;" class="btn-dark">
															<i class="fas fa-power-off"></i>
															</button>
														</c:when>
														<c:when test="${x.status==false}">
															<button type="submit" name="action" value="delete"
															style="border: none; opacity: 0.7;" class="btn-dark">
															<i class="fas fa-toggle-on"></i>
															</button>
														</c:when>
													</c:choose>
												</div>
											</div>
											<!-- /.card-header -->
											<div class="card-body">

												<div class="row">
													<img style="height: 250px;"
														src="${cssroot}/image/admin/${x.image}" width="100%"
														class="img-thumbnail" alt="">
												</div>

												<hr>

												<strong><i class="fas fa-pencil-alt mr-1"></i> Fee
													booking</strong>

												<p class="text-muted">
													<span class="tag tag-danger"> ${x.booking_Fee} % For
														Onetime </span>

												</p>
												<hr>

												<strong><i class="fas fa-shield-alt"></i> Satus</strong>

												<p class="text-muted">
													<span class="tag tag-danger"> <c:choose>
															<c:when test="${x.status == true}">
                                       		
                                       			Active
                                       		
                                       	</c:when>
															<c:when test="${x.status == false}">
                                       		
                                       			Disabled
                                       		
                                       	</c:when>

														</c:choose>

													</span>

												</p>
											</div>
											<!-- /.card-body -->
										</div>
										</form>
									</div>
								

							</c:when>
							<c:when test="${size == 2}">
								
									<div class="col-sm-6">
									<form action="/admin/updatetypeservice" method="GET">
										<div class="card card-success">
											<div class="card-header">
												<h3 class="card-title">${x.name}</h3>
												<div class="float-right">
													<button type="submit" name="action" value="update"
														style="border: none; opacity: 0.7;" class="btn-dark"
														data-toggle="modal" data-target="#modalPoll-1">
														<i class="fas fa-wrench"></i>
													</button>
													<c:choose>
														<c:when test="${x.status==true }">
															<button type="submit" name="action" value="delete"
															style="border: none; opacity: 0.7;" class="btn-dark">
															<i class="fas fa-power-off"></i>
															</button>
														</c:when>
														<c:when test="${x.status==false}">
															<button type="submit" name="action" value="delete"
															style="border: none; opacity: 0.7;" class="btn-dark">
															<i class="fas fa-toggle-on"></i>
															</button>
														</c:when>
													</c:choose>
												</div>
											</div>
											<!-- /.card-header -->
											<div class="card-body">

												<div class="row">
													<img style="height: 250px;"
														src="${cssroot}/image/admin/${x.image}" width="100%"
														class="img-thumbnail" alt="">
												</div>

												<hr>

												<strong><i class="fas fa-pencil-alt mr-1"></i> Fee
													booking</strong>

												<p class="text-muted">
													<span class="tag tag-danger"> ${x.booking_Fee} % For
														Onetime </span>

												</p>
												<hr>

												<strong><i class="fas fa-shield-alt"></i> Satus</strong>

												<p class="text-muted">
													<span class="tag tag-danger"> <c:choose>
															<c:when test="${x.status == true}">
                                       		
                                       			Active
                                       		
                                       	</c:when>
															<c:when test="${x.status == false}">
                                       		
                                       			Disabled
                                       		
                                       	</c:when>

														</c:choose>

													</span>

												</p>
											</div>
											<!-- /.card-body -->
										</div>
										</form>
									</div>
								

							</c:when>
							<c:otherwise>

								<form action="/admin/updatetypeservice" method="GET">
									<div class="col-sm-12">

										<div class="card card-success">
											<div class="card-header">
												<h3 class="card-title">${x.name}</h3>
												<div class="float-right">
													<button type="submit" name="action" value="update"
														style="border: none; opacity: 0.7;" class="btn-dark"
														data-toggle="modal" data-target="#modalPoll-1">
														<i class="fas fa-wrench"></i>
													</button>
													<c:choose>
														<c:when test="${x.status==true }">
															<button type="submit" name="action" value="delete"
															style="border: none; opacity: 0.7;" class="btn-dark">
															<i class="fas fa-power-off"></i>
															</button>
														</c:when>
														<c:when test="${x.status==false}">
															<button type="submit" name="action" value="delete"
															style="border: none; opacity: 0.7;" class="btn-dark">
															<i class="fas fa-toggle-on"></i>
															</button>
														</c:when>
													</c:choose>
												</div>
											</div>
											<!-- /.card-header -->
											<div class="card-body">

												<div class="row">
													<img style="height: 320px;"
														src="${cssroot}/image/admin/${x.image}" width="100%"
														class="img-thumbnail" alt="">
												</div>

												<hr>

												<strong><i class="fas fa-pencil-alt mr-1"></i> Fee
													booking</strong>

												<p class="text-muted">
													<span class="tag tag-danger"> ${x.booking_Fee} % For
														Onetime </span>

												</p>
												<hr>

												<strong><i class="fas fa-shield-alt"></i> Satus</strong>

												<p class="text-muted">
													<span class="tag tag-danger"> <c:choose>
															<c:when test="${x.status == true}">
                                       		
                                       			Active
                                       		
                                       	</c:when>
															<c:when test="${x.status == false}">
                                       		
                                       			Disabled
                                       		
                                       	</c:when>

														</c:choose>

													</span>

												</p>
											</div>
											<!-- /.card-body -->
										</div>

									</div>
								</form>

							</c:otherwise>

						</c:choose>

					</c:forEach>
				</c:if>


			</div>
		</div>

		<!--  Footer -->
		<div class="card-footer">
			<c:if test="${not empty listServiceFee}">
				<nav aria-label="Page navigation example ">
					<ul class="pagination justify-content-sm-center" id="pagination">
						<c:choose>
							<c:when test="${currentPageNumber == 1}">
								<li class="disabled page-item"><a class="page-link"
									href="#">&lt;&lt;</a></li>
								<li class="disabled page-item"><a class="page-link"
									href="#">&lt;</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="${firstUrl}">&lt;&lt;</a></li>
								<li class="page-item"><a class="page-link"
									href="${prevUrl}">&lt;</a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
							<c:url var="pageUrl" value="/admin/servicetype/${i}" />
							<c:choose>
								<c:when test="${i == currentPageNumber}">
									<li class="page-item active"><a class="page-link"
										href="${pageUrl}"><c:out value="${i}" /></a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link"
										href="${pageUrl}"><c:out value="${i}" /></a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${currentPageNumber == totalPages}">
								<li class="disabled page-item"><a class="page-link"
									href="#">&gt;</a></li>
								<li class="disabled page-item"><a class="page-link"
									href="#">&gt;&gt;</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link"
									href="${nextUrl}">&gt;</a></li>
								<li class="page-item"><a class="page-link"
									href="${lastUrl}">&gt;&gt;</a></li>
							</c:otherwise>
						</c:choose>

					</ul>
				</nav>
			</c:if>

		</div>
	</div>


</div>

<script>
	/* $.ajax({
	    url: 'http://localhost:8090/admin/delete/',
	    type: 'DELETE',
	    success: function (result) {
	        alert("thanh cong");
	    }
	}); */

	$("#add").click(function() {
		var url = "http://localhost:8090/admin/addservicetype";
		window.location.href = url;
	});
</script>