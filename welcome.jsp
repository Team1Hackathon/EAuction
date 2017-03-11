<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>The Great Indian Mahasale</title>
</head>
<body>
	HI Here is the list of items to bid.
	<form action="bidItem.jsp"> 
		<table>
			<tr><td><br/>
				<c:forEach items="${auctionItems}" var="auctionItem">
			  		 <br/> ItemId :  <c:out value="${auctionItem.get_id()}" /><br/>
			  		 ItemName :  <c:out value="${auctionItem.getItemName()}" /><br/>
			  		  ItemValue :  <c:out value="${auctionItem.getItemValue()}" /><br/>
			  		   ItemSource :  <c:out value="${auctionItem.getItemSource()}" />
			  		   <input type="hidden" value="${auctionItem}"/> 
			  		   <input type="submit" value="bid your Item"/>
				</c:forEach>
			</td></tr>
		</table>
	</form>
</body>
</html>