(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-9827af84"],{"06b2":function(t,i,e){},"11e9":function(t,i,e){var n=e("52a7"),s=e("4630"),o=e("6821"),a=e("6a99"),c=e("69a8"),r=e("c69a"),u=Object.getOwnPropertyDescriptor;i.f=e("9e1e")?u:function(t,i){if(t=o(t),i=a(i,!0),r)try{return u(t,i)}catch(e){}if(c(t,i))return s(!n.f.call(t,i),t[i])}},"2bb1":function(t,i,e){"use strict";var n=e("c31d"),s=e("d282"),o=Object(s["a"])("swipe-item"),a=o[0],c=o[1];i["a"]=a({data:function(){return{offset:0}},beforeCreate:function(){this.$parent.swipes.push(this)},destroyed:function(){this.$parent.swipes.splice(this.$parent.swipes.indexOf(this),1)},render:function(){var t=arguments[0],i=this.$parent,e=i.vertical,s=i.computedWidth,o=i.computedHeight,a={width:s+"px",height:e?o+"px":"100%",transform:"translate"+(e?"Y":"X")+"("+this.offset+"px)"};return t("div",{class:c(),style:a,on:Object(n["a"])({},this.$listeners)},[this.slots()])}})},"456d":function(t,i,e){var n=e("4bf8"),s=e("0d58");e("5eda")("keys",(function(){return function(t){return s(n(t))}}))},"482d":function(t,i,e){"use strict";function n(t,i,e){return Math.min(Math.max(t,i),e)}e.d(i,"a",(function(){return n}))},"4b0a":function(t,i,e){"use strict";e("68ef"),e("786d")},"4d48":function(t,i,e){"use strict";e("68ef"),e("bf60")},5596:function(t,i,e){"use strict";var n=e("d282"),s=e("1325"),o=e("3875"),a=e("5fbe"),c=e("4598"),r=e("482d"),u=Object(n["a"])("swipe"),h=u[0],f=u[1];i["a"]=h({mixins:[o["a"],Object(a["a"])((function(t,i){t(window,"resize",this.onResize,!0),i?this.initialize():this.clear()}))],props:{width:Number,height:Number,autoplay:Number,vertical:Boolean,indicatorColor:String,loop:{type:Boolean,default:!0},duration:{type:Number,default:500},touchable:{type:Boolean,default:!0},initialSwipe:{type:Number,default:0},showIndicators:{type:Boolean,default:!0}},data:function(){return{computedWidth:0,computedHeight:0,offset:0,active:0,deltaX:0,deltaY:0,swipes:[],swiping:!1}},watch:{swipes:function(){this.initialize()},initialSwipe:function(){this.initialize()},autoplay:function(t){t?this.autoPlay():this.clear()}},computed:{count:function(){return this.swipes.length},delta:function(){return this.vertical?this.deltaY:this.deltaX},size:function(){return this[this.vertical?"computedHeight":"computedWidth"]},trackSize:function(){return this.count*this.size},activeIndicator:function(){return(this.active+this.count)%this.count},isCorrectDirection:function(){var t=this.vertical?"vertical":"horizontal";return this.direction===t},trackStyle:function(){var t,i=this.vertical?"height":"width",e=this.vertical?"width":"height";return t={},t[i]=this.trackSize+"px",t[e]=this[e]?this[e]+"px":"",t.transitionDuration=(this.swiping?0:this.duration)+"ms",t.transform="translate"+(this.vertical?"Y":"X")+"("+this.offset+"px)",t},indicatorStyle:function(){return{backgroundColor:this.indicatorColor}},minOffset:function(){var t=this.$el.getBoundingClientRect();return(this.vertical?t.height:t.width)-this.size*this.count}},methods:{initialize:function(t){if(void 0===t&&(t=this.initialSwipe),clearTimeout(this.timer),this.$el){var i=this.$el.getBoundingClientRect();this.computedWidth=this.width||i.width,this.computedHeight=this.height||i.height}this.swiping=!0,this.active=t,this.offset=this.count>1?-this.size*this.active:0,this.swipes.forEach((function(t){t.offset=0})),this.autoPlay()},onResize:function(){this.initialize(this.activeIndicator)},onTouchStart:function(t){this.touchable&&(this.clear(),this.swiping=!0,this.touchStart(t),this.correctPosition())},onTouchMove:function(t){this.touchable&&this.swiping&&(this.touchMove(t),this.isCorrectDirection&&(Object(s["c"])(t,!0),this.move({offset:this.delta})))},onTouchEnd:function(){if(this.touchable&&this.swiping){if(this.delta&&this.isCorrectDirection){var t=this.vertical?this.offsetY:this.offsetX;this.move({pace:t>0?this.delta>0?-1:1:0,emitChange:!0})}this.swiping=!1,this.autoPlay()}},getTargetActive:function(t){var i=this.active,e=this.count;return t?this.loop?Object(r["a"])(i+t,-1,e):Object(r["a"])(i+t,0,e-1):i},getTargetOffset:function(t,i){var e=t*this.size;this.loop||(e=Math.min(e,-this.minOffset));var n=Math.round(i-e);return this.loop||(n=Object(r["a"])(n,this.minOffset,0)),n},move:function(t){var i=t.pace,e=void 0===i?0:i,n=t.offset,s=void 0===n?0:n,o=t.emitChange,a=this.loop,c=this.count,r=this.active,u=this.swipes,h=this.trackSize,f=this.minOffset;if(!(c<=1)){var l=this.getTargetActive(e),d=this.getTargetOffset(l,s);if(a){if(u[0]){var p=d<f;u[0].offset=p?h:0}if(u[c-1]){var v=d>0;u[c-1].offset=v?-h:0}}this.active=l,this.offset=d,o&&l!==r&&this.$emit("change",this.activeIndicator)}},swipeTo:function(t,i){var e=this;void 0===i&&(i={}),this.swiping=!0,this.resetTouchStatus(),this.correctPosition(),Object(c["a"])((function(){var n;n=e.loop&&t===e.count?0===e.active?0:t:t%e.count,e.move({pace:n-e.active,emitChange:!0}),i.immediate?Object(c["a"])((function(){e.swiping=!1})):e.swiping=!1}))},correctPosition:function(){this.active<=-1&&this.move({pace:this.count}),this.active>=this.count&&this.move({pace:-this.count})},clear:function(){clearTimeout(this.timer)},autoPlay:function(){var t=this,i=this.autoplay;i&&this.count>1&&(this.clear(),this.timer=setTimeout((function(){t.swiping=!0,t.resetTouchStatus(),t.correctPosition(),Object(c["a"])((function(){t.swiping=!1,t.move({pace:1,emitChange:!0}),t.autoPlay()}))}),i))},renderIndicator:function(){var t=this,i=this.$createElement,e=this.count,n=this.activeIndicator,s=this.slots("indicator");return s||(this.showIndicators&&e>1?i("div",{class:f("indicators",{vertical:this.vertical})},[Array.apply(void 0,Array(e)).map((function(e,s){return i("i",{class:f("indicator",{active:s===n}),style:s===n?t.indicatorStyle:null})}))]):void 0)}},render:function(){var t=arguments[0];return t("div",{class:f()},[t("div",{ref:"track",style:this.trackStyle,class:f("track"),on:{touchstart:this.onTouchStart,touchmove:this.onTouchMove,touchend:this.onTouchEnd,touchcancel:this.onTouchEnd}},[this.slots()]),this.renderIndicator()])}})},"5eda":function(t,i,e){var n=e("5ca1"),s=e("8378"),o=e("79e5");t.exports=function(t,i){var e=(s.Object||{})[t]||Object[t],a={};a[t]=i(e),n(n.S+n.F*o((function(){e(1)})),"Object",a)}},"5f7b":function(t,i,e){"use strict";var n=e("06b2"),s=e.n(n);s.a},"66b9":function(t,i,e){"use strict";e("68ef"),e("09fe")},7844:function(t,i,e){"use strict";e("68ef"),e("8270")},"786d":function(t,i,e){},"7b0a":function(t,i,e){},"81e6":function(t,i,e){"use strict";e("68ef"),e("7b0a")},8270:function(t,i,e){},"8e6e":function(t,i,e){var n=e("5ca1"),s=e("990b"),o=e("6821"),a=e("11e9"),c=e("f1ae");n(n.S,"Object",{getOwnPropertyDescriptors:function(t){var i,e,n=o(t),r=a.f,u=s(n),h={},f=0;while(u.length>f)e=r(n,i=u[f++]),void 0!==e&&c(h,i,e);return h}})},9093:function(t,i,e){var n=e("ce10"),s=e("e11e").concat("length","prototype");i.f=Object.getOwnPropertyNames||function(t){return n(t,s)}},"990b":function(t,i,e){var n=e("9093"),s=e("2621"),o=e("cb7c"),a=e("7726").Reflect;t.exports=a&&a.ownKeys||function(t){var i=n.f(o(t)),e=s.f;return e?i.concat(e(t)):i}},"9ffb":function(t,i,e){"use strict";var n=e("d282"),s=Object(n["a"])("col"),o=s[0],a=s[1];i["a"]=o({props:{span:[Number,String],offset:[Number,String],tag:{type:String,default:"div"}},computed:{gutter:function(){return this.$parent&&Number(this.$parent.gutter)||0},style:function(){var t=this.gutter/2+"px";return this.gutter?{paddingLeft:t,paddingRight:t}:{}}},methods:{onClick:function(t){this.$emit("click",t)}},render:function(){var t,i=arguments[0],e=this.span,n=this.offset;return i(this.tag,{style:this.style,class:a((t={},t[e]=e,t["offset-"+n]=n,t)),on:{click:this.onClick}},[this.slots()])}})},a411:function(t,i,e){"use strict";e.r(i);var n=function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"home"},[e("van-swipe",{staticClass:"home-swipe",attrs:{autoplay:3e3}},t._l(t.carousels,(function(i,n){return e("van-swipe-item",{key:n,on:{click:function(e){return t.clickSwipe(i.carouselUrl)}}},[e("img",{attrs:{src:i.carouselName}})])})),1),t._v(" "),e("div",{staticClass:"welcome"},[t._v(t._s(t.timeText)+"好，欢迎定制您的专属产品手册")]),t._v(" "),e("div",{staticClass:"start"},[e("van-button",{staticClass:"b-start",attrs:{type:"default",color:"#ffa500",round:""},on:{click:t.customize}},[e("div",{staticClass:"icon-c"},[e("van-icon",{staticClass:"iconfont",attrs:{"class-prefix":"icon",name:"dingzhiyewushenqing"}})],1),t._v(" "),e("div",{staticClass:"t-start"},[e("div",{staticClass:"div1"},[t._v("开 始 定 制")]),e("div",{staticClass:"div2"},[t._v("Customize Now")])])])],1),t._v(" "),e("div",{staticClass:"news"},[t._m(0),t._v(" "),t._l(t.news,(function(i,n){return e("div",{key:n,staticClass:"news-d",on:{click:function(e){return t.clickNews(i.newsUrl)}}},[e("img",{attrs:{src:i.newsName}})])}))],2),t._v(" "),e("van-goods-action",[e("van-goods-action-icon",[e("van-icon",{staticClass:"iconfont",attrs:{slot:"icon","class-prefix":"icon",name:"shouye"},slot:"icon"}),t._v("\n      首页\n    ")],1),t._v(" "),e("van-goods-action-icon",{attrs:{url:"https://www.continental-industry.com/zh-CN/TopNavi/Company/ContiTech-Division/Location-Profiles/China"}},[e("van-icon",{staticClass:"iconfont",attrs:{slot:"icon","class-prefix":"icon",name:"lianxiwomen"},slot:"icon"}),t._v("\n      联系我们\n    ")],1),t._v(" "),e("van-goods-action-icon",{attrs:{url:"https://www.continental-industry.com"}},[e("van-icon",{staticClass:"iconfont",attrs:{slot:"icon","class-prefix":"icon",name:"guanwang"},slot:"icon"}),t._v("\n      官网\n    ")],1),t._v(" "),e("van-goods-action-icon",[e("van-icon",{staticClass:"iconfont",attrs:{slot:"icon","class-prefix":"icon",name:"wode"},on:{click:t.goMine},slot:"icon"}),t._v("\n      我的\n    ")],1)],1)],1)},s=[function(){var t=this,i=t.$createElement,e=t._self._c||i;return e("div",{staticClass:"news-title"},[e("span",{staticStyle:{color:"#ffa500"}},[t._v("News ")]),t._v(" "),e("span",{staticStyle:{color:"#575656"}},[t._v("新闻报道")])])}],o=(e("8e6e"),e("456d"),e("ac6a"),e("28a5"),e("bd86")),a=(e("ef6f"),e("82a8")),c=(e("591c"),e("7713")),r=(e("93ac"),e("bb33")),u=(e("81e6"),e("9ffb")),h=(e("4d48"),e("d1e1")),f=(e("c3a6"),e("ad06")),l=(e("66b9"),e("b650")),d=(e("4b0a"),e("2bb1")),p=(e("7844"),e("5596")),v=e("afa4");function m(t){return Object(v["a"])({url:"/newSController/getAllNews",method:"get",params:t})}function g(t){return Object(v["a"])({url:"/carouselController/getAllCarouselVo",method:"get",params:t})}var b,w=e("c24f"),y=e("d697"),O=e("2f62");function j(t,i){var e=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);i&&(n=n.filter((function(i){return Object.getOwnPropertyDescriptor(t,i).enumerable}))),e.push.apply(e,n)}return e}function C(t){for(var i=1;i<arguments.length;i++){var e=null!=arguments[i]?arguments[i]:{};i%2?j(e,!0).forEach((function(i){Object(o["a"])(t,i,e[i])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(e)):j(e).forEach((function(i){Object.defineProperty(t,i,Object.getOwnPropertyDescriptor(e,i))}))}return t}var k={components:(b={},Object(o["a"])(b,p["a"].name,p["a"]),Object(o["a"])(b,d["a"].name,d["a"]),Object(o["a"])(b,l["a"].name,l["a"]),Object(o["a"])(b,f["a"].name,f["a"]),Object(o["a"])(b,h["a"].name,h["a"]),Object(o["a"])(b,u["a"].name,u["a"]),Object(o["a"])(b,r["a"].name,r["a"]),Object(o["a"])(b,c["a"].name,c["a"]),Object(o["a"])(b,a["a"].name,a["a"]),b),data:function(){return{carousels:[],news:[],timeText:""}},computed:C({},Object(O["b"])(["token"]),{user:{get:function(){return this.$store.state.app.user},set:function(t){this.$store.commit("app/setUser",t)}}}),created:function(){var t=window.location.href.split("token=")[1];if(t){var i=t.split("#/")[0];this.$store.dispatch("app/setToken",i),this.getData()}var e=(new Date).getHours();this.timeText=e>=6&&e<12?"早上":e>=12&&e<18?"下午":"晚上"},methods:{goMine:function(){this.$router.push({path:"/mine"})},customize:function(){this.$router.push("/customise")},clickSwipe:function(t){window.open(t,"_blank")},clickNews:function(t){window.open(t,"_blank")},getData:function(){var t=this;m().then((function(i){200===i.status&&(t.news=i.data,t.news.forEach((function(t){return t.newsName=y["a"]+t.newsName})))})),g().then((function(i){200===i.status&&(t.carousels=i.data,t.carousels.forEach((function(t){return t.carouselName=y["a"]+t.carouselName})))})),Object(w["a"])().then((function(i){200===i.status&&(t.user=i.data)}))}}},S=k,_=(e("5f7b"),e("2877")),x=Object(_["a"])(S,n,s,!1,null,"94e6557c",null);i["default"]=x.exports},afa4:function(t,i,e){"use strict";e("9a83");var n=e("f564"),s=e("bc3a"),o=e.n(s),a=e("4360"),c=o.a.create({baseURL:Object({NODE_ENV:"production",BASE_URL:"/"}).VUE_APP_BASE_API,timeout:1e4});c.interceptors.request.use((function(t){return a["a"].getters.token&&(t.headers["Authorization"]=a["a"].getters.token),t}),(function(t){return console.log(t),Promise.reject(t)})),c.interceptors.response.use((function(t){return t}),(function(t){return console.log("err"+t),Object(n["a"])({type:"warning",message:"请联系管理员"}),Promise.reject(t)})),i["a"]=c},bf60:function(t,i,e){},c24f:function(t,i,e){"use strict";e.d(i,"a",(function(){return s}));var n=e("afa4");function s(){return Object(n["a"])({url:"/users/findUsersByOpenid",method:"get"})}},d1e1:function(t,i,e){"use strict";var n=e("d282"),s=Object(n["a"])("row"),o=s[0],a=s[1];i["a"]=o({props:{type:String,align:String,justify:String,tag:{type:String,default:"div"},gutter:{type:[Number,String],default:0}},methods:{onClick:function(t){this.$emit("click",t)}},render:function(){var t,i=arguments[0],e=this.align,n=this.justify,s="flex"===this.type,o="-"+Number(this.gutter)/2+"px",c=this.gutter?{marginLeft:o,marginRight:o}:{};return i(this.tag,{style:c,class:a((t={flex:s},t["align-"+e]=s&&e,t["justify-"+n]=s&&n,t)),on:{click:this.onClick}},[this.slots()])}})},d697:function(t,i,e){"use strict";e.d(i,"a",(function(){return n}));var n="http://122.51.73.55:80"},f1ae:function(t,i,e){"use strict";var n=e("86cc"),s=e("4630");t.exports=function(t,i,e){i in t?n.f(t,i,s(0,e)):t[i]=e}}}]);
//# sourceMappingURL=chunk-9827af84.f25a25ce.js.map