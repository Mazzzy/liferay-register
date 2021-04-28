<%@ include file="/init.jsp" %>

<portlet:actionURL name="registerSubmit" var="registerSubmit" />
<aui:form action="<%= registerSubmit %>" method="post" name="registerSubmit">
  <aui:input label="Name" name="name" type="text">
  	<aui:validator name="required" />
  </aui:input>
  <aui:input label="Surname" name="surname" type="text">
  	<aui:validator name="required" />
  </aui:input>
  <aui:input label="Birthdate" name="bdate" type="date">
  	<aui:validator name="required" />
  	<aui:validator name="date" />
  </aui:input>
  <aui:input label="Email" name="email" type="email">
  	<aui:validator name="required" />
  	<aui:validator name="email" />
  </aui:input>

  <aui:button type="submit" />
</aui:form>