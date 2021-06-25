printjson(db.people.aggregate([
	{
		$unwind:"$credit"
	},
	{
		$group:
			{_id:"$credit.currency",
			 "sumBalance" : { $sum: 
				{$convert:{ input: "$credit.balance", to: "double"}}
			 }
			}
	}
]).toArray());
