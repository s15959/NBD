import riak


client = riak.RiakClient()
bucket = client.bucket('s15959')

dane = {'name': 'Aconite', 'sunNeeds': 'Partial', 'maxHeight': 6, 'overwinter': False}
flower = bucket.new('flower', dane)
flower.store()

inserted = bucket.get('flower')
print(inserted.data)

inserted.data['sunNeeds'] = 'Full'
inserted.store()


updated = bucket.get('flower')
print(updated.data)


updated.delete('flower')
deleted = bucket.get('flower')
print(deleted.data)


