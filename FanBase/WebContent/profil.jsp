<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script >

function validate_fileupload(fileName)
{
    var allowed_extensions = new Array("jpg","png","gif");
    var file_extension = fileName.split('.').pop().toLowerCase(); // split function will split the filename by dot(.), and pop function will pop the last element from the array which will give you the extension as well. If there will be no extension then it will return the filename.

    for(var i = 0; i <= allowed_extensions.length; i++)
    {
        if(allowed_extensions[i]==file_extension)
        {
            return true; // valid file extension
        }
    }

    return false;
}</script>
</head>
<body>
 <form method="post" action="Profil.do" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Description</td>
                    <td><textarea class="text" cols="50" rows ="5" name="description"></textarea></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" size="50"/></td>
                </tr>
                <tr>
                    <td>Image</td>
                    <td><input type="file" name="photo" size="50" onchange="validate_fileupload(this.value);"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
</body>
</html>