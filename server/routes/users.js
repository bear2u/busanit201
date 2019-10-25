var express = require('express');
var router = express.Router();

/* GET users listing. */
router.post('/auth', function(req, res, next) {
  const id = req.body.id;
  const pwd = req.body.pwd;  
  const User = {
    no: id,
    pwd,
    email: 'email',
    name: 'name',
  }
  res
    .json(User);
});

module.exports = router;
