printjson(
    db.people.mapReduce(
		function() {
			emit(this.sex, { weight: parseFloat(this.weight), height: parseFloat(this.height) }); 
		},
		function(keys, values) { 
			var weightSum = 0;
			var heightSum = 0;

			for(value of values){
			  weightSum += value.weight;
			  heightSum += value.height;
			}
			
			
			avgWeight = weightSum / values.length;
			avgHeight = heightSum / values.length;
			
			return {
			  avgWeight, avgHeight
			}; 
		},
		{
			out: {inline:1}
		}
	)
);