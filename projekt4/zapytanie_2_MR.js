printjson(
    db.people.mapReduce(
		function() {
			for(credit of this.credit){
				emit(credit.currency, {balance: parseFloat(credit.balance)}); 
			}
		},
		function(keys, values) { 
			var sumBalance = 0;

			for(value of values){
			  sumBalance += value.balance;
			}
			
			return sumBalance; 
		},
		{
			out: {inline:1}
		}
	)
);