printjson(db.people.aggregate([
	{
		$match:{sex:"Female",nationality:"Poland"}
	},
	{
		$unwind:"$credit"
	},
	{
		$group:
			{_id:"$credit.currency",
			 "sumBalance" : { $sum : 
				{$convert:{input: "$credit.balance",to: "double"}}
			 },
			 "avgBalance" : { $avg :
				{$convert:{input: "$credit.balance", to: "double"}}
			 }					
			}
	}
]).toArray());
