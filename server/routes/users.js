var express = require('express');
var router = express.Router();

/* GET users listing. */
router.post('/auth', function(req, res, next) {
  const id = req.body.email;
  const pwd = req.body.pwd;  
  res
    .json({result : (id == "test@test.com" && pwd == "1234")});
});

module.exports = router;
