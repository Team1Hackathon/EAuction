<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>The Great Indian Mahasale</title>
</head>
<body>
	Confirm to bid.
	<form action="/bidAuction"> 
		<table>
			<tr><td>
				Quote A Value : <input type="text" value="${auctionItem.getItemValue()}"> 
				Input Your name : <input type="text" value="${auctionItem.getItemName()}"> 
				<input type="submit" value="Confirm"/>		
			</td></tr>
		</table>
	</form>
</body>
</html>