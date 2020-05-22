var messageApiHistiry=Vue.resource('/history/{id}');
var messageApiClient=Vue.resource('/client/{id}');
var messageApiMain=Vue.resource('/history/test');

Vue.component('td-row',{
    props:['clientWeek'],
    // template:'<div>{{clientWeek}}</div>'
   template: '<tbody>' +
       '<template v-for="n in 16">'+
    '<template v-for="cli in clientWeek"  >' +
       // '<template v-for="cli in clientWeek" />'+
       '<tr v-if="cli.time==n+7">' +
       '<td>{{ n+7 }}:00 </td>'+
       '<td id="monday" :value="cli.clientName"></td>' +
       '<td id="tuesday"></td>' +
       '<td id="wednesday">if</td>' +
       '<td id="thursday"></td>' +
       '<td v-if="cli.day==friday" id="friday">cli.clientName</td>' +
       '<td v-else id="friday">{{cli.day}}</td>' +
       '<td id="saturday"></td>' +
       '<td id="sunday"></td>' +
       '</tr>' +
       '<tr v-else>' +
       '<td>{{ n+7 }}:00 </td>'+
       '<td id="monday" :value="cli.clientName"></td>' +
       '<td id="tuesday"></td>' +
       '<td id="wednesday">else</td>' +
       '<td id="thursday"></td>' +
       '<td id="friday"></td>' +
       '<td id="saturday"></td>' +
       '<td id="sunday"></td>' +
       '</tr>' +
       '</template>'+
       '</template>'+
       '</tbody>'
});

var app = new Vue({
    el: '#tableBody',
    template:'<table border="3" align="centre" class="table-striped" >'+
        '<thead>'+
        '<tr>'+
            '<th>ЧЧ:ММ</th>'+
            '<th>Понедельник</th>'+
            '<th>Вторник</th>'+
            '<th>Среда</th>'+
            '<th>Четверг</th>'+
            '<th>Пятница</th>'+
            '<th>Суббота</th>'+
            '<th>Воскресенье</th>'+
        '</tr>'+
        '</thead>'+
        '<td-row :clientWeek="clientWeek" />'+
// '<td-row v-for="n in 16" :key="n" :n="n" />'+
        '</table>',
    data:{clientWeek:[]},
    created:function(){
        messageApiMain.get().then(result=>
            result.json().then(
                data=>data.forEach(c=>this.clientWeek.push(c))
            )
        )
    }
});