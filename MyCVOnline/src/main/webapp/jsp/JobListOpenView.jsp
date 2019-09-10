<%@page import="in.co.job.portal.model.JobModel"%>
<%@page import="in.co.job.portal.util.DataUtility"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.job.portal.bean.JobBean"%>
<%@page import="in.co.job.portal.controller.JobListCtl"%>
<%@page import="in.co.job.portal.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job List</title>
</head>
<body>
<%@ include file="Header.jsp"%>
<main class="login-form">
	<div class="cotainer">
		<div class="row justify-content-center">
			<div class="col-md-8">
				<div class="card">
					<div class="card-header">
						Job List
						
						<h6 style="color: red;"><%=ServletUtility.getErrorMessage(request)%></h6>
						<h6 style="color: green;"><%=ServletUtility.getSuccessMessage(request)%></h6>
						
					</div>

					<div class="card-body">

						<form action="<%=JPView.JOB_LIST_CTL%>" method="post">
						
						<table class="table">
				<thead>
                    <tr>
                        <th><input type="text" class="form-control" placeholder="Company Name" name="cName" <%=ServletUtility.getParameter("cName", request)%>></th>
                        <th><input type="text" class="form-control" placeholder="Language" name="language" <%=ServletUtility.getParameter("language", request)%>></th>
                         <th><input style="background-color:#0b889c; color: white;" type="submit" class="form-control" name="operation" value="<%=JobListCtl.OP_SEARCH%>"></th>
                       
                    </tr>
                </thead>
						
						</table>
						
					 <table class="table">
               
                <thead>
                    <tr>
                    
                      
                        <th><b>S No.</b></th>
                        <th><b>Company Name</b></th>
                        <th><b>Language</b></th>
                        <th><b>Post Date</b></th>
                        <th><b>Post By</b></th>
                        <th><b>Description</b></th>
                        <th><b>Address</b></th>
                        <th><b>Action</b></th>
                        
                    </tr>
                </thead>
                
                <%
					int pageNo = ServletUtility.getPageNo(request);
					int pageSize = ServletUtility.getPageSize(request);
					int index = ((pageNo - 1) * pageSize) + 1;
					
					
					JobBean bean = null;
					
					List list = ServletUtility.getList(request);
					
					Iterator<JobBean> it = list.iterator();
					
					while (it.hasNext()) {
						bean = it.next();
				%>
                <tbody>
                    <tr>
                  
                       <td align="center"><%=index++%></td>
                       <td><%=bean.getCompanyName()%></td>
                      <td><%=bean.getLanguage()%></td>
                      <td align="center"><%=DataUtility.getDateString(bean.getPostDate())%></td>
                       <td><%=bean.getPostByRecId()%></td>
                         <td align="center"><%=bean.getDescription()%></td>
                         <td align="center"><%=bean.getAddress()%></td>
                        
                          
                          <td><a class="btn btn-primary" href="/MyCVOnline/LoginCtl">Apply</a> </td>
                      
                    </tr>
                 
                </tbody>
                  <%
					}
				%>
            </table>
            
            <table class="table">
				<thead>
                    <tr>
                         <th><input style="background-color:#0b889c; color: white;" type="submit" class="form-control"  name="operation"value="<%=JobListCtl.OP_PREVIOUS%>"
						<%=(pageNo == 1) ? "disabled" : ""%>></th>
                         
						<%
						JobModel model = new JobModel();
					%>
                         <th><input style="background-color:#0b889c; color: white;" type="submit" class="form-control"  name="operation"
						value="<%=JobListCtl.OP_NEXT%>"
						<%=((list.size() < pageSize) || model.nextPK() - 1 == bean.getId()) ? "disabled" : ""%>></th>
                    </tr>
                </thead>
						
						</table>
				<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
							
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	</main>
<%@ include file="Footer.jsp"%>
</body>
</html>