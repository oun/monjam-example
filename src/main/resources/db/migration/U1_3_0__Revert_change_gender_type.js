db.users.update({gender: 1},{$set: {gender: 'M'}}, {multi: true});
db.users.update({gender: 2},{$set: {gender: 'F'}}, {multi: true});