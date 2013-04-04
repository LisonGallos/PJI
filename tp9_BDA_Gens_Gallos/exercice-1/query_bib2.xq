
let $bib := "http://www.fil.univ-lille1.fr/~yroos/pxml/pxml-8/tp8/exercice-1/biblio.xml"
return
<results> 
   { 
   for $b in doc($bib)//book, 
       $t in $b/title, 
       $a in $b/author 
   return 
      <result> 
         {$t,$a} 
      </result> 
} 
</results>
