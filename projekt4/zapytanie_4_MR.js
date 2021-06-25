printjson(
    db.people.mapReduce(
		function() {
			emit(this.nationality, { weight: parseFloat(this.weight), height: (parseFloat(this.height)/100) }); 
		},
		function(keys, values) { 
			
			var maxBMI = 0;
			var minBMI = 0;
			var actualBMI = 0;
			var sumBMI = 0
			
			for(value of values){
				actualBMI = value.weight/Math.pow(value.height,2)
				if(minBMI == 0) minBMI = actualBMI;
				if(minBMI > actualBMI) minBMI = actualBMI;
				if(maxBMI < actualBMI) maxBMI = actualBMI; 
				sumBMI=sumBMI+actualBMI
			}
			
			var avgBMI = sumBMI/values.length
			
			return {
			  avgBMI, minBMI, maxBMI
			}; 
		},
		{
			out: {inline:1}
		}
	)
);