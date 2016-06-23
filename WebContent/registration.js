function validateForm()
{
	var a=document.forms["myForm"]["fname"].value;
	var x=document.forms["myForm"]["lname"].value;
	var b=document.forms["myForm"]["email"].value;
	var c=document.forms["myForm"]["addr1"].value;
	var d=document.forms["myForm"]["addr2"].value;
	var e=document.forms["myForm"]["city"].value;
	var f=document.forms["myForm"]["state"].value;
	var g=document.forms["myForm"]["zip"].value;
	var h=document.forms["myForm"]["country"].value;
	var i=document.forms["myForm"]["password"].value;
	var j=document.forms["myForm"]["cpassword"].value;
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

	if (a==null || a=="" || !isNaN(a))
	  {
	  alert("Please provide valid first name.");
	  return false;
	  }
	
	if (x==null || x=="" || !isNaN(x))
	  {
	  alert("Please provide valid last name.");
	  return false;
	  }
	
	if (!filter.test(b))
	  {
	  alert("Please provide valid email address.");
	  return false;
	  }

	if (c==null || c=="")
  	  {
  	  alert("Please provide a valid address 1.");
  	  return false;
  	  }
	
	if (d==null || d=="")
	  {
	  alert("Please provide a valid address 2.");
	  return false;
	  }
	
	if (e==null || e=="" || !isNaN(e))
	  {
	  alert("Please provide valid city name.");
	  return false;
	  }

	if (f==null || f=="" || !isNaN(f))
  	  {
  	  alert("Please provide valid state name.");
  	  return false;
  	  }

	if (g==null || g=="" || isNaN(g) || g.length!=5)
  	  {
  	  alert("Please provide valid 5 digit zip.");
  	  return false;
  	  }
	
	if (h==null || h=="" || !isNaN(h))
	  {
	  alert("Please provide valid country name.");
	  return false;
	  }

	if (i==null || i=="" || j==null || j=="")
  	  {
  	  alert("Please provide password.");
  	  return false;
  	  }

	if (i!=j)
  	  {
  	  alert("Password and confirm password donot match.");
  	  return false;
  	  }
	
}