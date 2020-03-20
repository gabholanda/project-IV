/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function readMore(){ 
    var rmore = document.getElementById("continued"); 
    var rmore2 = document.getElementById("readmore"); 
    var buttonReadMore = document.getElementById("readmore1"); 
    
    if (rmore.style.display === "none") { 
        rmore.style.display="inline"; 
        rmore2.style.display="none"; 
        buttonReadMore.innerHTML="+"; 
    } else { 
        rmore.style.display="none"; 
        rmore2.style.display="inline"; 
        buttonReadMore.innerHTML="-"; 
    }
}

function readMoreGarantia(){ 
    var rmoreGarantia = document.getElementById("garantia"); 
    var rmore2Garantia = document.getElementById("readmoreGarantia"); 
    var buttonReadMoreGarantia = document.getElementById("readmoreGarantias"); 
    
    if (rmoreGarantia.style.display === "none") { 
        rmoreGarantia.style.display="inline"; 
        rmore2Garantia.style.display="none"; 
        buttonReadMoreGarantia.innerHTML="+"; 
    } else { 
        rmoreGarantia.style.display="none"; 
        rmore2Garantia.style.display="inline"; 
        buttonReadMoreGarantia.innerHTML="-"; 
    }
}

function readMoreFrete(){ 
    var frete = document.getElementById("frete"); 
    var frete2 = document.getElementById("readmoreFrete"); 
    var buttonReadMoreFrete = document.getElementById("readmoreFretes"); 
    
    if (frete.style.display === "none") { 
        frete.style.display="inline"; 
        frete2.style.display="none"; 
        buttonReadMoreFrete.innerHTML="+"; 
    } else { 
        frete.style.display="none"; 
        frete2.style.display="inline"; 
        buttonReadMoreFrete.innerHTML="-"; 
    }
}




