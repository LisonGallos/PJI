
declare namespace html="http://www.w3.org/1999/xhtml"
declare function local:surface($maison as node()){ 
	let $surface := $maison//*/@surface-m2
	return sum($surface)
}; 


<html:html>

	<html:body>
		<html:table>
		<html:thead><html:tr><html:th>Maison</html:th><html:th>Surface (m2)</html:th></html:tr></html:thead>
		{ for $maison in doc("maisons.xml")//maison return

			<html:tr>

				<html:td>{$maison/@id}</html:td>

				<html:td>{local:surface($maison)}</html:td>

			</html:tr>

		}
		</html:table>
	</html:body>

</html:html>
		
