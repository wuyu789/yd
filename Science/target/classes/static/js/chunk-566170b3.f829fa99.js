(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-566170b3"],{"0653":function(t,e,n){"use strict";n("68ef")},"10d9":function(t,e,n){"use strict";var a=n("adde"),i=n.n(a);i.a},1437:function(t,e,n){"use strict";var a=n("c31d"),i=n("d282"),s=n("a142"),o=n("b1d2"),c=n("4598"),r=n("7744"),l=n("dfaf"),u=n("9884"),d=Object(i["a"])("collapse-item"),f=d[0],v=d[1],h=["title","icon","right-icon"];e["a"]=f({mixins:[Object(u["a"])("vanCollapse")],props:Object(a["a"])({},l["a"],{name:[Number,String],disabled:Boolean,isLink:{type:Boolean,default:!0}}),data:function(){return{show:null,inited:null}},computed:{currentName:function(){return Object(s["b"])(this.name)?this.name:this.index},expanded:function(){var t=this;if(!this.parent)return null;var e=this.parent,n=e.value,a=e.accordion;return a?n===this.currentName:n.some((function(e){return e===t.currentName}))}},created:function(){this.show=this.expanded,this.inited=this.expanded},watch:{expanded:function(t,e){var n=this;if(null!==e){t&&(this.show=!0,this.inited=!0);var a=t?this.$nextTick:c["b"];a((function(){var e=n.$refs,a=e.content,i=e.wrapper;if(a&&i){var s=a.offsetHeight;if(s){var o=s+"px";i.style.height=t?0:o,Object(c["a"])((function(){i.style.height=t?o:0}))}else n.onTransitionEnd()}}))}}},methods:{onClick:function(){if(!this.disabled){var t=this.parent,e=t.accordion&&this.currentName===t.value?"":this.currentName;this.parent.switch(e,!this.expanded)}},onTransitionEnd:function(){this.expanded?this.$refs.wrapper.style.height="":this.show=!1}},render:function(){var t,e=this,n=arguments[0],i=this.disabled,s=this.expanded,c=h.reduce((function(t,n){return e.slots(n)&&(t[n]=function(){return e.slots(n)}),t}),{});this.slots("value")&&(c.default=function(){return e.slots("value")});var l=n(r["a"],{attrs:{role:"button",tabindex:i?-1:0,"aria-expanded":String(s)},class:v("title",{disabled:i,expanded:s}),on:{click:this.onClick},scopedSlots:c,props:Object(a["a"])({},this.$props)}),u=this.inited&&n("div",{directives:[{name:"show",value:this.show}],ref:"wrapper",class:v("wrapper"),on:{transitionend:this.onTransitionEnd}},[n("div",{ref:"content",class:v("content")},[this.slots()])]);return n("div",{class:[v(),(t={},t[o["e"]]=this.index,t)]},[l,u])}})},"168a":function(t,e,n){"use strict";n.r(e);var a,i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"examples"},[a("div",{staticClass:"imglogo"},[a("img",{staticClass:"banner",attrs:{src:n("f5d9")}}),t._v(" "),a("img",{staticClass:"portrait",attrs:{src:t.person[0].img,alt:""}}),t._v(" "),a("div",{staticClass:"name"},[a("div",{staticClass:"chinesename"},[t._v(t._s(t.person[0].chinesename))]),t._v(" "),a("div",{staticClass:"englishname"},[t._v(t._s(t.person[0].englishname))])])]),t._v(" "),a("div",{staticClass:"history"},[a("van-cell",{attrs:{"title-style":"margin-left:10px"}},[a("van-icon",{staticClass:"iconfont icon",attrs:{"class-prefix":"icon",name:"jilu",color:"#ffa500"}}),t._v(" "),a("div",{staticClass:"title"},[t._v("发 送 记 录")])],1)],1),t._v(" "),a("div",{staticClass:"programme"},[a("van-collapse",{attrs:{accordion:""},model:{value:t.activeNames,callback:function(e){t.activeNames=e},expression:"activeNames"}},t._l(t.history,(function(e,n){return a("van-collapse-item",{key:n,attrs:{name:n}},[a("div",{attrs:{slot:"title"},slot:"title"},[a("span",{staticClass:"index"},[t._v(t._s(n<9?"0"+(n+1):n+1))]),t._v(" "),a("span",{staticClass:"title"},[t._v(t._s(e.sendName))]),t._v(" "),a("span",{staticClass:"data"},[t._v(t._s(e.sendTime))])]),t._v(" "),a("div",[t._v("\n                    已发送地址：\n                    "),t._l(e.address,(function(e,n){return a("div",{key:n,staticClass:"address"},[t._v(t._s(e))])}))],2)])})),1)],1),t._v(" "),a("van-goods-action",[a("van-goods-action-icon",[a("van-icon",{staticClass:"iconfont",attrs:{slot:"icon","class-prefix":"icon",name:"shouye"},on:{click:t.toHome},slot:"icon"}),t._v("\n            首页\n        ")],1),t._v(" "),a("van-goods-action-icon",{attrs:{url:"https://www.continental-industry.com/zh-CN/TopNavi/Company/ContiTech-Division/Location-Profiles/China"}},[a("van-icon",{staticClass:"iconfont",attrs:{slot:"icon","class-prefix":"icon",name:"lianxiwomen"},slot:"icon"}),t._v("\n            联系我们\n        ")],1),t._v(" "),a("van-goods-action-icon",{attrs:{url:"https://www.continental-industry.com"}},[a("van-icon",{staticClass:"iconfont",attrs:{slot:"icon","class-prefix":"icon",name:"guanwang"},slot:"icon"}),t._v("\n            官网\n        ")],1),t._v(" "),a("van-goods-action-icon",[a("van-icon",{staticClass:"iconfont",attrs:{slot:"icon","class-prefix":"icon",name:"wode"},on:{click:t.toMine},slot:"icon"}),t._v("\n            我的\n        ")],1)],1)],1)},s=[],o=(n("28a5"),n("ac6a"),n("bd86")),c=(n("342a"),n("1437")),r=(n("5d17"),n("f9bd")),l=(n("ef6f"),n("82a8")),u=(n("591c"),n("7713")),d=(n("93ac"),n("bb33")),f=(n("c3a6"),n("ad06")),v=(n("a52c"),n("2ed4")),h=(n("537a"),n("ac28")),b=(n("0653"),n("34e9")),m=(n("c194"),n("7744")),p=n("afa4");function g(t){return Object(p["a"])({url:"/sendRecord/selectSendRecordByUserId",method:"get",params:t})}var j={components:(a={},Object(o["a"])(a,m["a"].name,m["a"]),Object(o["a"])(a,b["a"].name,b["a"]),Object(o["a"])(a,h["a"].name,h["a"]),Object(o["a"])(a,v["a"].name,v["a"]),Object(o["a"])(a,f["a"].name,f["a"]),Object(o["a"])(a,d["a"].name,d["a"]),Object(o["a"])(a,u["a"].name,u["a"]),Object(o["a"])(a,l["a"].name,l["a"]),Object(o["a"])(a,r["a"].name,r["a"]),Object(o["a"])(a,c["a"].name,c["a"]),a),data:function(){return{active:0,person:[{img:n("f5d9"),chinesename:"大陆集团康迪泰克",englishname:"Continental Industry"}],activeNames:["1"],history:[]}},mounted:function(){var t=this;g({}).then((function(e){200===e.status&&(t.history=e.data,t.history.forEach((function(t){t.sendTime=t.sendTime.split("T")[0],t.address=t.sendEmail.split(",")})))}))},methods:{toHome:function(){this.$router.push({path:"/home"})},toMine:function(){this.$router.push({path:"/mine"})}}},C=j,x=(n("10d9"),n("2877")),O=Object(x["a"])(C,i,s,!1,null,"e54e70b2",null);e["default"]=O.exports},"2ed4":function(t,e,n){"use strict";var a=n("c31d"),i=n("d282"),s=n("a142"),o=n("ad06"),c=n("6f2f"),r=n("48f4"),l=n("9884"),u=Object(i["a"])("tabbar-item"),d=u[0],f=u[1];e["a"]=d({mixins:[Object(l["a"])("vanTabbar")],props:Object(a["a"])({},r["c"],{dot:Boolean,icon:String,name:[Number,String],info:[Number,String]}),data:function(){return{active:!1}},computed:{routeActive:function(){var t=this.to,e=this.$route;if(t&&e){var n=Object(s["c"])(t)?t:{path:t},a=n.path===e.path,i=Object(s["b"])(n.name)&&n.name===e.name;return a||i}}},methods:{onClick:function(t){this.parent.onChange(this.name||this.index),this.$emit("click",t),Object(r["b"])(this.$router,this)}},render:function(){var t=arguments[0],e=this.icon,n=this.slots,a=this.parent.route?this.routeActive:this.active,i=this.parent[a?"activeColor":"inactiveColor"];return t("div",{class:f({active:a}),style:{color:i},on:{click:this.onClick}},[t("div",{class:f("icon")},[n("icon",{active:a})||e&&t(o["a"],{attrs:{name:e}}),t(c["a"],{attrs:{dot:this.dot,info:this.info}})]),t("div",{class:f("text")},[n("default",{active:a})])])}})},"342a":function(t,e,n){"use strict";n("68ef"),n("09fe"),n("bff0")},"34e9":function(t,e,n){"use strict";var a=n("2638"),i=n.n(a),s=n("d282"),o=n("ba31"),c=n("b1d2"),r=Object(s["a"])("cell-group"),l=r[0],u=r[1];function d(t,e,n,a){var s,r=t("div",i()([{class:[u(),(s={},s[c["f"]]=e.border,s)]},Object(o["b"])(a,!0)]),[n.default&&n.default()]);return e.title||n.title?t("div",[t("div",{class:u("title")},[n.title?n.title():e.title]),r]):r}d.props={title:String,border:{type:Boolean,default:!0}},e["a"]=l(d)},"537a":function(t,e,n){"use strict";n("68ef"),n("9312")},"5d17":function(t,e,n){"use strict";n("68ef")},7744:function(t,e,n){"use strict";var a=n("c31d"),i=n("2638"),s=n.n(i),o=n("d282"),c=n("a142"),r=n("dfaf"),l=n("ba31"),u=n("48f4"),d=n("ad06"),f=Object(o["a"])("cell"),v=f[0],h=f[1];function b(t,e,n,a){var i=e.icon,o=e.size,r=e.title,f=e.label,v=e.value,b=e.isLink,m=e.arrowDirection,p=n.title||Object(c["b"])(r),g=n.default||Object(c["b"])(v),j=n.label||Object(c["b"])(f),C=j&&t("div",{class:[h("label"),e.labelClass]},[n.label?n.label():f]),x=p&&t("div",{class:[h("title"),e.titleClass],style:e.titleStyle},[n.title?n.title():t("span",[r]),C]),O=g&&t("div",{class:[h("value",{alone:!n.title&&!r}),e.valueClass]},[n.default?n.default():t("span",[v])]),_=n.icon?n.icon():i&&t(d["a"],{class:h("left-icon"),attrs:{name:i}}),w=n["right-icon"],y=w?w():b&&t(d["a"],{class:h("right-icon"),attrs:{name:m?"arrow-"+m:"arrow"}});function k(t){Object(l["a"])(a,"click",t),Object(u["a"])(a)}var N=b||e.clickable,S={clickable:N,center:e.center,required:e.required,borderless:!e.border};return o&&(S[o]=o),t("div",s()([{class:h(S),attrs:{role:N?"button":null,tabindex:N?0:null},on:{click:k}},Object(l["b"])(a)]),[_,x,O,y,n.extra&&n.extra()])}b.props=Object(a["a"])({},r["a"],{},u["c"]),e["a"]=v(b)},9312:function(t,e,n){},a52c:function(t,e,n){"use strict";n("68ef"),n("09fe"),n("ae73")},ac28:function(t,e,n){"use strict";var a=n("d282"),i=n("9884"),s=n("b1d2"),o=Object(a["a"])("tabbar"),c=o[0],r=o[1];e["a"]=c({mixins:[Object(i["b"])("vanTabbar")],props:{route:Boolean,activeColor:String,inactiveColor:String,safeAreaInsetBottom:Boolean,value:{type:[Number,String],default:0},border:{type:Boolean,default:!0},fixed:{type:Boolean,default:!0},zIndex:{type:Number,default:1}},watch:{value:"setActiveItem",children:"setActiveItem"},methods:{setActiveItem:function(){var t=this;this.children.forEach((function(e,n){e.active=(e.name||n)===t.value}))},onChange:function(t){t!==this.value&&(this.$emit("input",t),this.$emit("change",t))}},render:function(){var t,e=arguments[0];return e("div",{style:{zIndex:this.zIndex},class:[(t={},t[s["f"]]=this.border,t),r({fixed:this.fixed,"safe-area-inset-bottom":this.safeAreaInsetBottom})]},[this.slots()])}})},adde:function(t,e,n){},ae73:function(t,e,n){},afa4:function(t,e,n){"use strict";n("9a83");var a=n("f564"),i=n("bc3a"),s=n.n(i),o=n("4360"),c=s.a.create({baseURL:Object({NODE_ENV:"production",BASE_URL:"/"}).VUE_APP_BASE_API,timeout:1e4});c.interceptors.request.use((function(t){return o["a"].getters.token&&(t.headers["Authorization"]=o["a"].getters.token),t}),(function(t){return console.log(t),Promise.reject(t)})),c.interceptors.response.use((function(t){return t}),(function(t){return console.log("err"+t),Object(a["a"])({type:"warning",message:"请联系管理员"}),Promise.reject(t)})),e["a"]=c},bff0:function(t,e,n){},c194:function(t,e,n){"use strict";n("68ef"),n("09fe")},dfaf:function(t,e,n){"use strict";n.d(e,"a",(function(){return a}));var a={icon:String,size:String,center:Boolean,isLink:Boolean,required:Boolean,clickable:Boolean,titleStyle:null,titleClass:null,valueClass:null,labelClass:null,title:[Number,String],value:[Number,String],label:[Number,String],arrowDirection:String,border:{type:Boolean,default:!0}}},f5d9:function(t,e,n){t.exports=n.p+"static/img/mine.97cae406.jpg"},f9bd:function(t,e,n){"use strict";var a=n("d282"),i=n("9884"),s=n("b1d2"),o=Object(a["a"])("collapse"),c=o[0],r=o[1];e["a"]=c({mixins:[Object(i["b"])("vanCollapse")],props:{accordion:Boolean,value:[String,Number,Array],border:{type:Boolean,default:!0}},methods:{switch:function(t,e){this.accordion||(t=e?this.value.concat(t):this.value.filter((function(e){return e!==t}))),this.$emit("change",t),this.$emit("input",t)}},render:function(){var t,e=arguments[0];return e("div",{class:[r(),(t={},t[s["f"]]=this.border,t)]},[this.slots()])}})}}]);
//# sourceMappingURL=chunk-566170b3.f829fa99.js.map