var express = require('express');
var router = express.Router();

/* GET users listing. */
router.post('/auth', function(req, res, next) {
  const email = req.body.email;
  const pwd = req.body.pwd;  

  if(email != 'test@test.com') {
    return res.json(null);
  }

  const User = {
    no: 1,
    email,
    name : email + "님"
  }
  res
    .json(User);
});

module.exports = router;
