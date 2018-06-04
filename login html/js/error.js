
let ret=document.getElementById('ret');
let s=setInterval(function(){
      if(ret.innerText<=0){
      	clearInterval(s);
      	location.assign('login.html');
     }
     ret.innerText-=1;
},1000);