import { NgModule } from '@angular/core';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { CardComponent } from './components/card/card.component';

@NgModule({
    imports: [
        PRIMENG_IMPORTS,
    ],
    providers: [],
    exports: [
        PRIMENG_IMPORTS,
    ],
    declarations: [CardComponent]
})
export class SharedModule { }
