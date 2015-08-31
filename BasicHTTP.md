#A basic description of how HTTP works.

# Basic HTTP #
> If you consider the world wide web as a big black box where you deliver a paper slip with some basic information. The black box does it's magic. And then returns another slip of paper, with the given result.

> What happens in the black box is depending on what web server there is behind, if it is running Linux, BSD, or Microsoft, if it is Java, ASP, PHP or another programming language.

> In the real world the paper slip is the web browser that sends information to the black box of your choice (web server) and the returning paper slip is the web page that is displayed.

> The sending paper slip is the request, we request a file and a content out from a lot of parameters, depending on language, URL, Method, and the returning paper slip is the response that returns the response code (you know about 404), and a response content.

> The request and response contains a lot of information about how the transaction of information went between the two parties.

> ## REQUEST ##
> {{{ Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,**/**;q=0.8
> Accept-Encoding:gzip,deflate,sdch
> Accept-Language:sv,en-US;q=0.8,en;q=0.6,da;q=0.4
> Connection:keep-alive
> Cookie:**> Host:google.com
> User-Agent:Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36
> X-Chrome-Variations:CIO2yQEIk7bJAQijtskBCKm2yQEIwbbJAQiehsoBCJOIygEIlorKAQjHksoB }}}**

> ## RESPONSE ##
> {{{ Alternate-Protocol:80:quic
> Cache-Control:public, max-age=2592000
> Content-Length:219
> Content-Type:text/html; charset=UTF-8
> Date:Wed, 18 Dec 2013 12:50:56 GMT
> Expires:Fri, 17 Jan 2014 12:50:56 GMT
> Location:http://www.google.com/
> Server:gws
> X-Frame-Options:SAMEORIGIN
> X-XSS-Protection:1; mode=block }}}

> This is very useful since you can copy this information in to different ways, either to spoof outgoing or incoming signals.

# HTTP Hacking #
> HTTP does not need to be read from a web browser. You can communicate HTTP with any socket.
> In most HTTP addresses there is a system that can be changed to get the desired result.

> In some shops you can use the web address to alter the given information www.shop.com/toys/cars/yellow/, in this case you could assume if you enter www.shop.com/toys/cars/green/ you would get a list of all the green cars in the shop and if you removed it all together www.shop.com/toys/cars/ you would get a list of all toy-cars regardless of colour.

> On other sites the url hack is more parametrized, and the web address would look like this www.shop.com/?category=toys&subcat=cars?color=yellow, though this line is difficiult to read for both humans and search crawlers.

# RESTfull #
> RESTfull is a way to use the HTTP hack to build web-services using the above principle.

> /Make/Model/Fuel/Year/
> /Ford/ -> Returns all Ford cars
> /Ford/Fiesta/ -> Returns all ford fiesta
> /Ford/Fiesta/Diesel/ -> Returns all ford fiesta that is running diesel.
> /Ford/Fiesta/Ethanol/ -> Returns all ford fiesta that runs ethanol.

> In our specific case it is cell/id/ more parameters can be added to the adress bar if wished, to get more detailed subcategories, or to sort.
# JavaScript #
> JavaScript is getting more popular the last few years, even though most people wouldn't touch JavaScript a few years ago.

> JavaScript has become more powerful since XHR has been properly implemented in 2006, there is currently 3 standards in XHR development. One from Microsoft (1999), one from Mozilla (2000), one from W3C (2006).

> Frameworks such as jQuery has made it easier to use XHR (Ajax), since it auto-magically detect what XHR standard your browser use, and make the call with that one.

> ## WHY? (PROS) ##
> Many may ask, WHY would I want to use JavaScript.
> Simply put, you can distribute alot of powerful tools to the user side.

> Lets say you have a validation running on your server, that server get polled 200+ times per second. You have to run the validation and then return a response if it is right or wrong.

> Lets say you would want a persons Personal Number from a text field. If the text field is empty or if the personal number standards (eg. writing 13 in the location of the month), you would be able to stop the poll to the server and reduce the amount of polling on the server, by doing the calculation client side.

> User-friendliness. You can make user interfaces that looks nice.

> ## WHY NOT? (CONS) ##
> JavaScript is not as confusing as it was before, with frameworks like jQuery, it is possible to get by the cross browser confusion, and well documented functions, makes it possible to choose between those functions that supports your required browser.

> Well even though it is possible to find frameworks that solves many problems like the ajax discussed before, frameworks cannot make up for the diversity of how to do things in the browser. Since most browser developers decided to do it their own way.

> This makes it difficult to find a function that works the exact same way in all browsers.

# Listeners #
> When making JavaScript development, make sure to not mix code and JavaScript.
> document.getElementById('id').onclick = function(); = <div></div>
> function foo(){} = var foo = function(){}
> Demonstrate jQuery selectors.
  * how javascript development console.*** how quick javascript framework / Prototyping.**
# Loaders #
> Externals. - 

&lt;script src="code.js"&gt;



&lt;/script&gt;


> > Insert libraries and context here.

> $(document).ready(function(){ <-- DOM
> > Insert stuff that changes the page visually here.

> $(window).load(function(){ <-- onload
> > Everything else here. <-- (Eg. Facebook / Google+ / banners and adds here.