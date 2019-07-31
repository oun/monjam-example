db.users.update({gender: 'M'},{$set: {gender: 1}}, {multi: true});
db.users.update({gender: 'F'},{$set: {gender: 2}}, {multi: true});