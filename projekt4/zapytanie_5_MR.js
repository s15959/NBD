printjson(
    db.people.mapReduce(
		function() {
			for(credit of this.credit){
				emit(credit.currency, {balance: parseFloat(credit.balance)}); 
			}
		},
		function(keys, values) { 
			var sumBalance = 0;
			var avgBalance = 0;

			for(value of values){
			  sumBalance += value.balance;
			}
			
			avgBalance = sumBalance/values.length
			
			return {sumBalance,avgBalance}; 
		},
		{
			out: {inline:1},
			query:{sex:"Female", nationality:"Poland"}
		}
	)
);