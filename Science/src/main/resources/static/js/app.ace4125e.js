(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["app"],{0:function(n,e,t){n.exports=t("56d7")},"034f":function(n,e,t){"use strict";var o=t("64a9"),a=t.n(o);a.a},4360:function(n,e,t){"use strict";var o=t("2b0e"),a=t("2f62"),u={products:function(n){return n.app.products},user:function(n){return n.app.user},result:function(n){return n.app.result},token:function(n){return n.app.token}},c=u,r={products:[],result:[],token:"",user:{companyName:"大陆集团康迪泰克",contactPerson:"张先生",email:"yidiansheji@outlook.com",handbookName:"工业胶管合成"}},i={SET_PRODUCTS:function(n,e){n.products=e},SET_USER:function(n,e){n.user=e},SET_RESULT:function(n,e){n.result=e},SET_TOKEN:function(n,e){n.token=e}},s={setProducts:function(n,e){var t=n.commit;t("SET_PRODUCTS",e)},setUser:function(n,e){var t=n.commit;t("SET_USER",e)},setResult:function(n,e){var t=n.commit;t("SET_RESULT",e)},setToken:function(n,e){var t=n.commit;t("SET_TOKEN",e)}},m={namespaced:!0,state:r,mutations:i,actions:s},l=t("0e44");o["a"].use(a["a"]);var f=new a["a"].Store({modules:{app:m},getters:c,plugins:[Object(l["a"])()]});e["a"]=f},"56d7":function(n,e,t){"use strict";t.r(e);t("e17f");var o=t("2241"),a=(t("cadf"),t("551c"),t("f751"),t("097d"),t("2b0e")),u=t("2f62"),c=t("bc3a"),r=t.n(c),i=t("4328"),s=t.n(i),m=function(){var n=this,e=n.$createElement,t=n._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},l=[],f=(t("034f"),t("2877")),p={},d=Object(f["a"])(p,m,l,!1,null,null,null),h=d.exports,b=(t("ac6a"),t("8c4f"));a["a"].use(b["a"]);var k=[{path:"*",redirect:"/home"},{name:"user",component:function(){return t.e("chunk-a130e45a").then(t.bind(null,"718b"))},meta:{title:"我的"}},{name:"home",component:function(){return Promise.all([t.e("chunk-2b01a8b5"),t.e("chunk-2fb9b564")]).then(t.bind(null,"a411"))},meta:{title:"首页"}},{name:"goods",component:function(){return Promise.all([t.e("chunk-09b3e8d5"),t.e("chunk-4e35c169")]).then(t.bind(null,"00ce"))},meta:{title:"商品详情"}},{name:"customise",component:function(){return Promise.all([t.e("chunk-d79f4254"),t.e("chunk-45991f42"),t.e("chunk-2ccc04bc")]).then(t.bind(null,"c5d4"))},meta:{title:"定制中心"}},{name:"send",component:function(){return Promise.all([t.e("chunk-d79f4254"),t.e("chunk-443067e6"),t.e("chunk-b937e274")]).then(t.bind(null,"844e"))},meta:{title:"send"}},{name:"information",component:function(){return Promise.all([t.e("chunk-d79f4254"),t.e("chunk-7ce5ea96")]).then(t.bind(null,"c74b"))},meta:{title:"information"}},{name:"mine",component:function(){return t.e("chunk-660bbed2").then(t.bind(null,"6f73"))},meta:{title:"mine"}},{name:"history",component:function(){return Promise.all([t.e("chunk-2b01a8b5"),t.e("chunk-566170b3")]).then(t.bind(null,"168a"))},meta:{title:"history"}},{name:"infomanage",component:function(){return Promise.all([t.e("chunk-36a03d32"),t.e("chunk-ed05805c")]).then(t.bind(null,"97a3"))},meta:{title:"infomanage"}}];k.forEach((function(n){n.path=n.path||"/"+(n.name||"")}));var E=new b["a"]({routes:k});E.beforeEach((function(n,e,t){document.title="大陆集团康迪泰克";var o=function(){return-1!==navigator.userAgent.toLowerCase().indexOf("micromessenger")};if(!o())return alert("请用微信浏览器打开！"),!1;t()}));var v=t("4360");t("8e1f");a["a"].prototype.$axios=r.a,a["a"].prototype.qs=s.a,a["a"].use(u["a"]),a["a"].use(o["a"]),new a["a"]({router:E,store:v["a"],el:"#app",render:function(n){return n(h)}})},"64a9":function(n,e,t){},"8e1f":function(n,e,t){}},[[0,"runtime","chunk-libs"]]]);
//# sourceMappingURL=app.ace4125e.js.map