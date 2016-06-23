
function formSubmit(){
    document.getElementById("bookCount").submit();
}
    

function catalogUpdate(){
	var objTag = document.getElementById("bodyInformation");
    if (objTag != null){
    	objTag.setAttribute('data', 'catalog.jsp');
    	var element = document.getElementById("NavigationLink");
		element.innerHTML = "Home > Catalog";
		
		document.getElementById("NavigationLink").style.color='#ff0000';
		document.getElementById("catalogLink").style.color='#ff0000';
		document.getElementById("homeLink").style.color='#9b9087';
		document.getElementById("cartLink").style.color='#9b9087';
		
		//document.getElementById("hidden").setAttribute("value", docc);
    }
}	

function indexUpdate(){
	var objTag = document.getElementById("bodyInformation");
   	if (objTag != null){
   		objTag.setAttribute('data', 'IndexInfo.jsp');
		var element = document.getElementById("NavigationLink");
		element.innerHTML = "Home";
				
		document.getElementById("NavigationLink").style.color='#ff0000';
		document.getElementById("catalogLink").style.color='#9b9087';
		document.getElementById("homeLink").style.color='#ff0000';
		document.getElementById("cartLink").style.color='#9b9087';
						
   	}
}

function cartUpdate(docc1){
	var objTag = document.getElementById("bodyInformation");
   	if (objTag != null){
   		objTag.setAttribute('data', 'cart.jsp');
   		var element = document.getElementById("NavigationLink");
		element.innerHTML = "Home > Cart";
				
		document.getElementById("NavigationLink").style.color='#ff0000';
		document.getElementById("catalogLink").style.color='#9b9087';
		document.getElementById("homeLink").style.color='#9b9087';
		document.getElementById("cartLink").style.color='#ff0000';
		
		document.getElementsById("hiddenCart").setAttribute("value", docc1);
  	}
}
/*
function toItem(docc2){
	document.getElementsByName("hidden")[0].setAttribute('data', 'item.html');
		
	document.getElementById("hiddenItem").setAttribute("value", docc2);
}

function toCartFromItem(){
	document.getElementsByName("hiddenItem")[0].setAttribute('data', 'cart.html');
		
}

function toCart(){
	document.getElementsByName("hiddenCart")[0].setAttribute('data', 'cart.html');
}


function afterCheckout(){
	document.getElementsByName("hiddenCart")[0].setAttribute('data', 'IndexInfo.html');
}
*/
function changecatalog(){
	
	var e = document.getElementById("changeCatalog");
	var opt = e.options[e.selectedIndex].value;
	
		
	if(opt=='Fiction'){
		document.getElementById("A_1").style.display = 'none';
		document.getElementById("A_2").style.display = 'none';
		document.getElementById("A_3").style.display = 'none';
		document.getElementById("A_4").style.display = 'none';
		document.getElementById("F_1").style.display = '';
		document.getElementById("F_2").style.display = '';
		document.getElementById("F_3").style.display = '';
	}else if(opt=='Art'){
		document.getElementById("A_1").style.display = '';
		document.getElementById("A_2").style.display = '';
		document.getElementById("A_3").style.display = '';
		document.getElementById("A_4").style.display = '';
		document.getElementById("F_1").style.display = 'none';
		document.getElementById("F_2").style.display = 'none';
		document.getElementById("F_3").style.display = 'none';
	}else{
		document.getElementById("F_1").style.display = '';
		document.getElementById("F_2").style.display = '';
		document.getElementById("F_3").style.display = '';
		document.getElementById("A_1").style.display = '';
		document.getElementById("A_2").style.display = '';
		document.getElementById("A_3").style.display = '';
		document.getElementById("A_4").style.display = '';
	}
	
	
}

function itemSelected(){
	var objTag = document.getElementById("CatalogInfo");
	var element = document.getElementById("test123");
	element.innerHTML = "Home > Catalog > Item";
	
    if (objTag != null){
    	objTag.setAttribute('data', 'item.jsp');    	
		
		document.getElementById("NavigationLink").style.color='#ff0000';
		document.getElementById("catalogLink").style.color='#ff0000';
		document.getElementById("homeLink").style.color='#9b9087';
		document.getElementById("cartLink").style.color='#9b9087';
		
    }
}	

	