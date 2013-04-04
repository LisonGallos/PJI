xquery version "1.0";

(: Generated with EditiX at Wed Apr 03 16:31:12 CEST 2013 :)

declare function local:get-plants-by-light($light) { 
	let $plants := doc("/home/avenou/Documents/Master1/M1S2/ModelChecking/tp9/exercice-3/plant_catalog.xml")//PLANT[LIGHT = $light]
	for $plant in $plants
	return 
		<PLANT>
			{$plant/COMMON}
			{$plant/BOTANICAL}
			{$plant/ZONE}
			{$plant/PRICE}
			{$plant/AVAILABILITY}
		</PLANT>
};

let $lights := distinct-values(doc("/home/avenou/Documents/Master1/M1S2/ModelChecking/tp9/exercice-3/plant_catalog.xml")//LIGHT)
return
	<CATALOG>
	{
	for $light in $lights
	return 
		<LIGHT>
			<EXPOSURE>{$light}</EXPOSURE>
			{local:get-plants-by-light($light)}
		</LIGHT>
	}
	</CATALOG>
