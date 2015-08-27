<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html lang="fr" class="no-js">
<head>
<meta charset="utf-8">
<link rel="shortcut icon" type="image/x-icon" href="images/icones/favicon.ico">
<title>Cube-Lanta | Le plus réaliste Koh-Lanta sur Minecraft</title>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,400,700,600,300' rel='stylesheet' type='text/css'>

<link href="modifs.css" media="screen" rel="stylesheet">
<link href="style.css" media="screen" rel="stylesheet">
<link href="screen.css" media="screen" rel="stylesheet">
<link href="boutique.css" media="screen" rel="stylesheet">
<!--<link href="custom.css" media="screen" rel="stylesheet">-->

</head>
<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/fr_FR/sdk.js#xfbml=1&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<div class="body_wrap">

	<?php include("HautDePage.php") ?>

	<div id="middle" class="cols2">
		<div class="container">

				<div class="content " role="main">
		 	
            <div class="postlist clearfix" style='margin-top:-36px;'>
	
		<div class="post-item ">
            <div class="post-image"></div>				
			<div class="post-title">
			<img src="images/icones/Papier.png" style="width: 40px;float: left;margin-right: 20px;">
			<h2>Inscription:</h2></div>
				<div class="post-meta-top">

				</div>
				<div class="post-desc clearfix" style='max-height:2000px;overflow:auto;'>
				<?php if ($_POST['code'] == "cubelantasaison2")
				{
					?>
					<p><strong>Les résultats vous seront dévoilés lors de la finale de la Saison 1 de Cube-Lanta !</strong></p>
					<iframe src="https://docs.google.com/forms/d/1KBUzdn5ZODEd1g89XnuvvZPGrTLXF-cCYpV6F_kELdE/viewform?embedded=true" width="530" height="700" frameborder="0" marginheight="0" marginwidth="0">Chargement en cours...</iframe>
					<?php
					
				}
				else
				{
					?>
					<p>Veuillez <strong><a href='https://docs.google.com/document/d/1b144_6_vDOe4r-q9qBrzfsK45ExpfoZh19TRE1uN3XQ/edit'>lire les règles</a></strong> avant de remplir le formulaire.</p>
				
				<form action="inscription.php" method="post">
<p>Code: 
    <input type="text" name="code" />
    <input type="submit" value="Valider" />
</p>
</form>
				<?php
				}
				?>
				
				
                                </div>
				</div>
					</div>

               

				</div>

			<!-- menu -->
            <?php include("menu.php") ?>
						              
  	
		
		<div class="clear"></div>
		</div>		
        
        <?php include("BasDePage.php") ?>
	</div></div>
</body>
</html>	