<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>:: Registration ::</title>
<BODY>
	<div>
		<form action="addEmployee.go" method="post">
			<center>
				<table border="1" width="30%" cellpadding="5">
					<thead>
						<tr>
							<th colspan="2">Enter Information Here</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>First Name</td>
							<td><input type="text" name="firstName" value="" /></td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td><input type="text" name="lastName" value="" /></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="text" name="emailId" value="" /></td>
						</tr>
						<tr>
							<td>Password</td>
							<td><input type="password" name="password" value="" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" /></td>
							<td><input type="reset" value="Reset" /></td>
						</tr>
						<tr>
							<td colspan="2">Already registered!! <a href="login.go">Login
									Here</a></td>
						</tr>
					</tbody>
				</table>
			</center>
		</form>
	</div>
</BODY>
</HTML>
