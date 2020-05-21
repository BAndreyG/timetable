var messageApiHistiry=Vue.resource('/history/{id}');
var messageApiClient=Vue.resource('/client/{id}');
var messageApiMain=Vue.resource('/history/test');

Vue.component('message-row',{
    props:['message'],
   // template: '<div><i>({{ message.date }})</i> {{ message.client.name }}</div>'
//     template:'<div>'+
//     '<span v-for="n in 16" :key="n">{{ n+7 }}:00 </span>'+
// '</div>'
   template: '<div id="2">' +
       '<tr v-for="n in 16" :key="n">' +
       '<td>{{ n+7 }}:00 </td>'+
       '<td><input type="text" value="{{message.client.name}}"></td>' +
       '<td><input type="text"></td>' +
       '<td><input type="text"></td>' +
       '<td><input type="text"></td>' +
       '<td><input type="text"></td>' +
       '</tr>' +
       '</div>'
});
Vue.component('messages-list', {
    props:['mes'],
    template: '<div id="1"><message-row v-for="message in mes"  :key="message.id"  :message="message" /></div>',
    created:function(){
        messageApiMain.get().then(result=>
            result.json().then(
                data=>data.forEach(message=>this.mes.push(message))
            )
        )
    }
});

var app = new Vue({
    el: '#tableBody',
    // el: '#app',
    template: '<messages-list :mes="messages" />',
    data: {messages: []}
});