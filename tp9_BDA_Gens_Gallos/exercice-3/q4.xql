xquery version "1.0";

(: Generated with EditiX at Wed Apr 03 19:00:23 CEST 2013 :)

declare function local:get-price-order-by-plants($order) {
	let $catalog := doc("/home/avenou/Documents/Master1/M1S2/ModelChecking/tp9/exercice-3/plant_catalog.xml")
	let $plants := $order//PLANT
	for $plant in $plants
	return number(substring($catalog//PLANT[COMMON = $plant/COMMON]/PRICE, 2)) * $plant/QUANTITY
};
declare function local:get-price-order($order) {
	let $price-by-plant := local:get-price-order-by-plants($order)
	return round-half-to-even(sum($price-by-plant), 1)
};

let $order := doc("/home/avenou/Documents/Master1/M1S2/ModelChecking/tp9/exercice-3/plant_order.xml")
return <PRICE>{local:get-price-order($order)}</PRICE>
