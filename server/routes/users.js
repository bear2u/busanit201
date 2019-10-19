var express = require('express');
var router = express.Router();

/* GET users listing. */
router.post('/auth', function(req, res, next) {
  const id = req.body.id;
  const pwd = req.body.password;  
  res
    .json({result : (id == "test" && pwd == "1234")});
});

module.exports = router;
