xquery version "1.0";

(: Generated with EditiX at Wed Apr 03 12:18:03 CEST 2013 :)

declare function local:get-family-name($plant as node()*) as xs:string { 
	let $family := doc("/home/avenou/Documents/Master1/M1S2/ModelChecking/tp9/exercice-3/plant_families.xml")//FAMILY[SPECIES/text() = $plant/BOTANICAL/text()]/NAME
	return $family/text()
};

let $plants := doc("/home/avenou/Documents/Master1/M1S2/ModelChecking/tp9/exercice-3/plant_catalog.xml")//PLANT
return
	<resultat>
	{
	for $plant in $plants
	return 
		<PLANT>
			{$plant/COMMON}
			{$plant/BOTANICAL}
			{$plant/ZONE}
			{$plant/LIGHT}
			{$plant/PRICE}
			{$plant/AVAILABILITY}
			<FAMILY>{local:get-family-name($plant)}</FAMILY>
		</PLANT>
	}
	</resultat>
