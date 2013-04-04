xquery version "1.0";

(: Generated with EditiX at Wed Apr 03 17:34:40 CEST 2013 :)

declare function local:get-family-name($plant) as xs:string { 
	let $family := doc("/home/avenou/Documents/Master1/M1S2/ModelChecking/tp9/exercice-3/plant_families.xml")//FAMILY[SPECIES/text() = $plant/BOTANICAL/text()]/NAME
	return $family/text()
};
declare function local:get-plants-by-light($light) { 
	let $plants := doc("/home/avenou/Documents/Master1/M1S2/ModelChecking/tp9/exercice-3/plant_catalog.xml")//PLANT[LIGHT = $light]
	for $plant in $plants
	order by $plant/COMMON
	return 
		<PLANT>
			{$plant/COMMON}
			{$plant/BOTANICAL}
			{$plant/ZONE}
			{$plant/PRICE}
			{$plant/AVAILABILITY}
			<FAMILY>{local:get-family-name($plant)}</FAMILY>
		</PLANT>
};

let $lights := distinct-values(doc("/home/avenou/Documents/Master1/M1S2/ModelChecking/tp9/exercice-3/plant_catalog.xml")//LIGHT)
return
	<CATALOG>
	{
	for $light in $lights
	order by $light
	return 
		<LIGHT>
			<EXPOSURE>{$light}</EXPOSURE>
			{local:get-plants-by-light($light)}
		</LIGHT>
	}
	</CATALOG>
